package com.neusoft.commerce.ctrls.bvo;

import com.neusoft.commerce.common.Result;
import com.neusoft.commerce.ctrls.BaseCtrl;
import com.neusoft.commerce.models.SysUser;
import com.neusoft.commerce.models.WitWishlist;
import com.neusoft.commerce.models.dto.WishProductDTO;
import com.neusoft.commerce.services.impl.WitWishlistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/31
 */
@Controller
public class BvoWishCtrl extends BaseCtrl {

    @Autowired
    private WitWishlistServiceImpl witWishlistService;



    //心愿单列表
    @GetMapping("/bvo/wish/list")
    public String wishList(HttpSession session, Model model){
        SysUser user =(SysUser) session.getAttribute("user");

        //根据借卖方id查询心愿单
        List<WishProductDTO> wishProductDTOS = witWishlistService.selectWishList(user.getManBuyerId());

        model.addAttribute("wish",wishProductDTOS);

        return "bvo-wishlist";
    }





    //加入心愿单
    @GetMapping("/bvo/wish/add")
    @ResponseBody
    public Result addToStore(HttpSession session, Integer proId){
        try {
            SysUser user =(SysUser) session.getAttribute("user");
            //先查表 有则修改
            WitWishlist witWishlist = witWishlistService.selectByProId(proId);
            if(witWishlist==null){  //insert
                WitWishlist wishlist=new WitWishlist();
                wishlist.setProId(proId);
                wishlist.setDsrId(user.getManBuyerId());
                witWishlistService.insertSelective(wishlist);
            }else {
                witWishlistService.updateByProId(proId);
            }
            return this.send(200,"已加入心愿单√");
        }catch (Exception e){
            e.printStackTrace();
            return this.send(-1,"操作失败");
        }
    }

    //移除心愿单（支持批量）
    @GetMapping("/bvo/wish/remove")
    @ResponseBody
    public Result removeFromStore(Integer[] id){
        try {
            witWishlistService.batchRemove(id);
            return this.send(200,"已移除心愿单");
        }catch (Exception e){
            e.printStackTrace();
            return this.send(-1,"操作失败");
        }
    }
}
