package com.neusoft.commerce.ctrls.bvo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neusoft.commerce.common.OrderCodeFactory;
import com.neusoft.commerce.common.Result;
import com.neusoft.commerce.ctrls.BaseCtrl;
import com.neusoft.commerce.dao.SysUserMapper;
import com.neusoft.commerce.models.*;
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
    @Autowired
    private StoStoreOrderServiceImpl stoStoreOrderService;
    @Autowired
    private SolStoreOrderLineItemServiceImpl storeOrderLineItemService;
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private SalSalesOrderLineItemServiceImpl salesOrderLineItemService;






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


            //生成订单

            for(int i:id){

                //1.插入原始订单sto store表
                StoStoreOrder storeOrder=new StoStoreOrder();
                storeOrder.setStrId(i);
                storeOrder.setOrderId(OrderCodeFactory.getOrderCode(new Long(user.getManBuyerId())));
                storeOrder.setCreatedBy(user.getUsername());
                stoStoreOrderService.insert(storeOrder);

                //2.插入原始订单详细 sol
                SolStoreOrderLineItem storeOrderLineItem=new SolStoreOrderLineItem();
                storeOrderLineItem.setStoId(storeOrder.getStoId());
                storeOrderLineItem.setCreatedBy(user.getUsername());
                storeOrderLineItem.setSalesPrice(product.getPrice());
                storeOrderLineItem.setQty(1);
                storeOrderLineItem.setSkuNo(product.getSkuCd());
                storeOrderLineItemService.insert(storeOrderLineItem);

                //3.插入销售订单 sao_sales_order
                SaoSalesOrder salesOrder=new SaoSalesOrder();
                salesOrder.setStoId(storeOrder.getStoId());
                salesOrder.setCreatedBy(user.getUsername());
                salesOrder.setProductAmount(product.getPrice());
                salesOrder.setManId(product.getManId());
                salesOrder.setOrderNo(OrderCodeFactory.getOrderCode(new Long(user.getManBuyerId())));
                salesOrder.setOrderSts("1"); // 待支付
                salesOrder.setDeliverySts("1"); //发货状态 1. SYNC - 已同步到仓库 2. STOCK_OUT - 已出库 3. SHIPPING - 发货中 4. FULFILLED - 已妥投
                orderService.insert(salesOrder);

                //4.插入销售详细订单
                SalSalesOrderLineItem salSalesOrderLineItem=new SalSalesOrderLineItem();
                salSalesOrderLineItem.setSaoId(salesOrder.getSaoId());
                salSalesOrderLineItem.setSolId(storeOrderLineItem.getSolId());  //原始订单详细
                salSalesOrderLineItem.setProId(product.getProId());
                salSalesOrderLineItem.setQty(1);
                salSalesOrderLineItem.setPrice(product.getPrice());
                salSalesOrderLineItem.setTrackingNo(Long.toString(OrderCodeFactory.getRandom(new Long(product.getProId()))));  //物流追踪号
                salesOrderLineItemService.insert(salSalesOrderLineItem);
            }

            return this.send(200,"推送成功,订单已生成,快去查看吧");
        }catch (Exception e){
            e.printStackTrace();
            return this.send(-1,"操作失败");
        }
    }





}
