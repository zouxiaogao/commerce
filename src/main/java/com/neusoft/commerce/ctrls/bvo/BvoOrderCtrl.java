package com.neusoft.commerce.ctrls.bvo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neusoft.commerce.common.PasswordUtil;
import com.neusoft.commerce.common.Result;
import com.neusoft.commerce.ctrls.BaseCtrl;
import com.neusoft.commerce.models.*;
import com.neusoft.commerce.models.dto.GmcFundDTO;
import com.neusoft.commerce.models.dto.OrderDto;
import com.neusoft.commerce.models.dto.RecordAuditDTO;
import com.neusoft.commerce.services.impl.*;
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
    @Autowired
    private GmcAccountFundServiceImpl gmcAccountFundService;
    @Autowired
    private SysUserServiceImpl sysUserService;
    @Autowired
    private ProductServiceImpl productService;


    @GetMapping("/bvo/order/show")
    public String showOrder() {
        return "bvo-orderlist";
    }

    @GetMapping("/bvo/order/list")
    @ResponseBody
    public Result OrderList(HttpServletRequest request, String status) {
        try {
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

            if(stoIds.size()>0){
                List<OrderDto> orders = saoSalesOrderService.selectSaoOrderByStos(stoIds, status);
                if(orders!=null){
                    for (OrderDto order : orders) {
                        //数量
                        BigDecimal qty=new BigDecimal(order.getQty());
                        //价格
                        BigDecimal price = order.getPrice();
                        order.setTotal(qty.multiply(price));
                    }
                }
                return this.send(200, "查询成功", orders);
            }else {
                return this.send(200, "查询成功",null);
            }




        }catch (Exception e){
            e.printStackTrace();
            return this.send(-1, "查询失败");
        }
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

        //查询用户
//        SysUser sysUser = sysUserService.selectByAccount(user.getUsername());
        model.addAttribute("name",user.getUsername());

        model.addAttribute("account",gmcFundDTO);

        model.addAttribute("order",order);
        return "bvo-orderPayment";
    }



    //支付
    @PostMapping("/bvo/order/pay")
    @ResponseBody
    public Result pay(HttpSession session,@RequestBody String str){
        try {
            SysUser user = (SysUser)session.getAttribute("user");
            JSONObject object= JSON.parseObject(str);

            String name = object.getString("name"); //收货人
            String address= object.getString("address"); //地址
            Integer amount = object.getInteger("amount"); //数量
            String phone = object.getString("phone"); //手机
            String code = object.getString("code"); //邮编
            String ship = object.getString("ship");//发货方式
            BigDecimal total = object.getBigDecimal("total"); //总价
            String wallet = object.getString("wallet");//支付方式
            BigDecimal money = object.getBigDecimal("money");//余额
            String password = object.getString("password");//支付密码
            Integer orderId = object.getInteger("orderId"); //订单id
            Integer proId = object.getInteger("proId");//商品id


            //根据商品id查找商家id
            ProProduct product = productService.selectByPrimaryKey(proId);

            //查找商家钱包
            GmcpAccount brand = gmcpAccountService.selectByBuyerId(product.getManId());

            GmcFundDTO gmcFundDTO = gmcpAccountService.selectMoneyByBuyerId(brand.getBuyerId());

            //查找当前用户钱包
            GmcpAccount gmcpAccount = gmcpAccountService.selectByBuyerId(user.getManBuyerId());
            if(PasswordUtil.encryptedPasswordBySha256(password).equals(user.getPassword())){
                if(money.compareTo(total)==-1){
                    return this.send(-1,"余额不足，支付失败");
                }
                //去支付
                gmcAccountFundService.payMoney(gmcpAccount.getBuyerId(),brand.getBuyerId(),name,address,amount,phone,code,total,wallet,money,gmcFundDTO.getAvailableMoney(),password,orderId);

            }else {
                return this.send(-1,"支付密码错误");
            }
            return this.send(200,"支付成功");
        }catch (Exception e){
            e.printStackTrace();
            return this.send(-1,"操作失败");
        }

    }
}
