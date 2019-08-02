package com.neusoft.commerce.ctrls.bvo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neusoft.commerce.common.Result;
import com.neusoft.commerce.ctrls.BaseCtrl;
import com.neusoft.commerce.models.GmcpAccount;
import com.neusoft.commerce.models.StoStoreOrder;
import com.neusoft.commerce.models.StrStore;
import com.neusoft.commerce.models.SysUser;
import com.neusoft.commerce.models.dto.GmcFundDTO;
import com.neusoft.commerce.models.dto.OrderDto;
import com.neusoft.commerce.services.impl.BvoServiceImpl;
import com.neusoft.commerce.services.impl.GmcpAccountServiceImpl;
import com.neusoft.commerce.services.impl.OrderServiceImpl;
import com.neusoft.commerce.services.impl.StoStoreOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zqy
 * @Date 2019/08/02
 */
@Controller
public class BvoOrderCtrl extends BaseCtrl {

    @Autowired
    private OrderServiceImpl saoSalesOrderService;
    @Autowired
    private BvoServiceImpl bvoServiceImpl;
    @Autowired
    private StoStoreOrderServiceImpl storeOrderService;
    @Autowired
    private GmcpAccountServiceImpl gmcpAccountService;


    @GetMapping("/bvo/order/show")
    public String showOrder() {
        return "bvo-orderlist";
    }

    @GetMapping("/bvo/order/list")
    @ResponseBody
    public Result OrderList(HttpServletRequest request, String status) {
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        //1.查询店铺
        List<StrStore> strStores = bvoServiceImpl.selectStoreByDsrId(user.getManBuyerId());

        //查询店铺订单
        List<Integer> ids = new ArrayList<>();
        for (StrStore store : strStores) {
            ids.add(store.getStrId());
        }
        List<StoStoreOrder> stoStoreOrders = storeOrderService.selectStoreOrderList(ids);

        //根据店铺订单ids查询销售订单
        List<Integer> stoIds = new ArrayList<>();
        for (StoStoreOrder storeOrder : stoStoreOrders) {
            stoIds.add(storeOrder.getStoId());
        }

        List<OrderDto> orders = saoSalesOrderService.selectSaoOrderByStos(stoIds, status);

        for (OrderDto order : orders) {
            //数量
            BigDecimal qty=new BigDecimal(order.getQty());
            //价格
            BigDecimal price = order.getPrice();
            order.setTotal(qty.multiply(price));
        }
        return this.send(200, "查询成功", orders);
    }


    //跳转到支付页面
    @GetMapping("/bvo/order/paypage")
    public String showPay(HttpSession session,Integer orderId, Model model) {

        //查询订单
        OrderDto order = saoSalesOrderService.selectOrderDetailBySaoId(orderId);

        //计算总计
        //数量
        BigDecimal qty=new BigDecimal(order.getQty());
        //价格
        BigDecimal price = order.getPrice();
        order.setTotal(qty.multiply(price));

        SysUser user = (SysUser)session.getAttribute("user");
        //查找钱包
        GmcpAccount gmcpAccount = gmcpAccountService.selectByBuyerId(user.getManBuyerId());

        //查询余额
        GmcFundDTO gmcFundDTO = gmcpAccountService.selectMoneyByBuyerId(gmcpAccount.getBuyerId());
        model.addAttribute("account",gmcFundDTO);

        model.addAttribute("order",order);
        return "bvo-orderPayment";
    }



    //支付
    @PostMapping("/bvo/order/pay")
    @ResponseBody
    public Result pay(HttpSession session,String str){
        try {
            SysUser user = (SysUser)session.getAttribute("user");
            JSONObject object= JSON.parseObject(str);

            return this.send(200,"支付成功");
        }catch (Exception e){
            return this.send(-1,"操作失败");
        }

    }
}
