package com.neusoft.commerce.ctrls;

import com.neusoft.commerce.common.Result;
import com.neusoft.commerce.models.SysUser;
import com.neusoft.commerce.models.dto.OrderDto;
import com.neusoft.commerce.models.dto.ProductDTO;
import com.neusoft.commerce.services.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/23
 */
@Controller
public class BrandOrderCtrl extends BaseCtrl{

    @Autowired
    private OrderServiceImpl saoSalesOrderService;


    @GetMapping("/brand-orderlist")
    public String brandOrderList(){
        return "brand-orderlist";
    }


//    @GetMapping("/brand/orderlist")
//    public String OrderList(HttpServletRequest request, Model model,String status){
//        SysUser user =(SysUser) request.getSession().getAttribute("user");
//        //默认显示未支付订单
//        List<OrderDto> orderDtos = saoSalesOrderService.selectOrderByManId(user.getManBuyerId(),status);
//        model.addAttribute("orderlist",orderDtos);
//        return "brand-orderlist";
//    }


    @GetMapping("/brand/orderlist")
    @ResponseBody
    public Result OrderList(HttpServletRequest request, String status){
        SysUser user =(SysUser) request.getSession().getAttribute("user");
        //默认显示未支付订单
        List<OrderDto> orderDtos = saoSalesOrderService.selectOrderByManId(user.getManBuyerId(),status);
        return this.send(200,"查询成功",orderDtos);
    }


    @GetMapping("/brand/updateShip")
    @ResponseBody
    public Result updateShip(HttpServletRequest request, String status,Integer saoId){

        if(status.equals("2")) {//待发货
            saoSalesOrderService.updateBySaoId(saoId,"3");  //发货
        }else if(status.equals("3")){ //已发货
            saoSalesOrderService.updateBySaoId(saoId,"2");  //待发货
        }

        return this.send(200,"操作成功");
    }

//    @GetMapping("/brand/search")
//    public String brandProductSearch(HttpServletRequest request, Model model,String tittle){
//        SysUser user =(SysUser) request.getSession().getAttribute("user");
//        model.addAttribute("products",saoSalesOrderService.selectOrderByManIdAndCondition(user.getManBuyerId(),tittle));
//        return "brand-orderlist::orderlist";
//    }
}
