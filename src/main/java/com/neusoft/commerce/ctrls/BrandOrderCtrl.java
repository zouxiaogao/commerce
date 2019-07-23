package com.neusoft.commerce.ctrls;

import com.neusoft.commerce.models.SysUser;
import com.neusoft.commerce.models.dto.OrderDto;
import com.neusoft.commerce.models.dto.ProductDTO;
import com.neusoft.commerce.services.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/23
 */
@Controller
public class BrandOrderCtrl {

    @Autowired
    private OrderServiceImpl saoSalesOrderService;


    @GetMapping("/brand-orderlist")
    public String brandOrderList(){
        return "brand-orderlist";
    }


    @GetMapping("/brand/orderlist")
    public String OrderList(HttpServletRequest request, Model model){
        SysUser user =(SysUser) request.getSession().getAttribute("user");
        //默认显示未支付订单
        List<OrderDto> orderDtos = saoSalesOrderService.selectOrderByManId(user.getManBuyerId(),"1");
        model.addAttribute("orderlist",orderDtos);
        return "/brand-orderlist::orderlist";
    }

//    @GetMapping("/brand/search")
//    public String brandProductSearch(HttpServletRequest request, Model model,String tittle){
//        SysUser user =(SysUser) request.getSession().getAttribute("user");
//        model.addAttribute("products",saoSalesOrderService.selectOrderByManIdAndCondition(user.getManBuyerId(),tittle));
//        return "brand-orderlist::orderlist";
//    }
}
