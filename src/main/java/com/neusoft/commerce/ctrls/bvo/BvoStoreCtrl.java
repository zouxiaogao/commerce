package com.neusoft.commerce.ctrls.bvo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neusoft.commerce.common.Result;
import com.neusoft.commerce.ctrls.BaseCtrl;
import com.neusoft.commerce.dao.SysUserMapper;
import com.neusoft.commerce.models.DrpDropshipPrice;
import com.neusoft.commerce.models.SdiStoreDropshipItem;
import com.neusoft.commerce.models.StrStore;
import com.neusoft.commerce.models.SysUser;
import com.neusoft.commerce.models.dto.ProductDTO;
import com.neusoft.commerce.services.StroeServiceImpl;
import com.neusoft.commerce.services.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/30
 */
@Controller
public class BvoStoreCtrl extends BaseCtrl {

    @Autowired
    private BvoServiceImpl bvoServiceImpl;
    @Autowired
    private StroeServiceImpl stroeService;

    @Autowired
    private SysUserServiceImpl sysUserService;
    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private DrpDropshpServiceImpl drpDropshpService;
    @Autowired
    private SdiStoreDropShipServiceImpl sdiStoreDropShipService;


    //网店管理

    @GetMapping("/bvo/store/show")
    public String showStore(HttpSession session, Model model){
        SysUser user =(SysUser) session.getAttribute("user");

        //查找是否有网店
        List<StrStore> strStores = bvoServiceImpl.selectStoreByDsrId(user.getManBuyerId());
        if(strStores.size()==0){
            model.addAttribute("msg","您还没有店铺，快去创建一个吧");
            return "bvo-goodsstoreAdd";
        }else {
            model.addAttribute("store",strStores);
            return "bvo-goodsstoreAdd";
        }

    }

    @GetMapping("/bvo/store/showAdd")
    public String showAddStore(){
        return "bvo-shops";
    }


    @PostMapping("/bvo/store/save")
    @ResponseBody
    public Result saveStore(HttpSession session, @RequestBody StrStore strStore ){
        try {
            SysUser sysUser =(SysUser) session.getAttribute("user");
            SysUser user= sysUserService.selectByPrimaryKey(sysUser.getUserId());
            strStore.setDsrId(user.getManBuyerId());
            stroeService.insertSelective(strStore);
            return this.send(200,"操作成功");

        }catch (Exception e){
            return this.send(-1,"操作失败");
        }
    }



    //借卖
    @GetMapping("/bvo/store/choose")
    public String chooseStore(HttpSession session, Model model,Integer id){
        SysUser user =(SysUser) session.getAttribute("user");

        //查找是否有网店
        List<StrStore> strStores = bvoServiceImpl.selectStoreByDsrId(user.getManBuyerId());
//        //查询借卖商品的信息
//        ProductDTO productDTO = productService.selectProductByProId(id);
        if(strStores.size()==0){
            model.addAttribute("msg","您还没有店铺，快去创建一个吧");
            return "bvo-goodsstoreAdd";
        }else {
            model.addAttribute("store",strStores);
            model.addAttribute("proId",id);
            return "bvo-goodsstorechoose";
        }

    }


    //推送
    @PostMapping("/bvo/store/push")
    @ResponseBody
    @Transactional
    public Result pushStore(HttpSession session,Integer[] id,Integer proId){

        try {
            SysUser user =(SysUser) session.getAttribute("user");

            //查询推送的商品信息
            ProductDTO product = productService.selectProductByProId(proId);

            //drp,sdi
            DrpDropshipPrice dropshipPrice=new DrpDropshipPrice();
            dropshipPrice.setOfpId(product.getOfpId());  //商品价格id
            dropshipPrice.setDsrId(user.getManBuyerId());   //借卖方id
            drpDropshpService.insertSelective(dropshipPrice);


            //网店关系表
            for(int i:id){
                SdiStoreDropshipItem sdiStoreDropshipItem=new SdiStoreDropshipItem();
                sdiStoreDropshipItem.setProId(proId);  //商品id
                sdiStoreDropshipItem.setDropshipPrice(product.getPrice()); //借卖价格
                sdiStoreDropshipItem.setStrId(i);
                sdiStoreDropShipService.insertSelective(sdiStoreDropshipItem);
            }


            return this.send(200,"推送成功,订单已生成,快去查看吧");
        }catch (Exception e){
            e.printStackTrace();
            return this.send(-1,"操作失败");
        }
    }
}
