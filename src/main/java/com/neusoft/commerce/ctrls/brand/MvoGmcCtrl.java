package com.neusoft.commerce.ctrls.brand;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neusoft.commerce.common.PasswordUtil;
import com.neusoft.commerce.common.Result;
import com.neusoft.commerce.ctrls.BaseCtrl;
import com.neusoft.commerce.models.GmcpAccount;
import com.neusoft.commerce.models.GmcpAccountFund;
import com.neusoft.commerce.models.SysUser;
import com.neusoft.commerce.models.dto.GmcFundDTO;
import com.neusoft.commerce.models.dto.RecordAuditDTO;
import com.neusoft.commerce.services.impl.GmcAccountFundServiceImpl;
import com.neusoft.commerce.services.impl.GmcpAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author zqy
 * @Date 2019/08/19
 */
@Controller
public class MvoGmcCtrl extends BaseCtrl {

    @Autowired
    private GmcpAccountServiceImpl gmcpAccountService;
    @Autowired
    private GmcAccountFundServiceImpl gmcAccountFundService;

    @GetMapping("/mvo/gmc/show")
    public String showGmc(HttpSession session, Model model){
        SysUser user = (SysUser)session.getAttribute("user");
        //查找钱包是否存在
        GmcpAccount gmcpAccount = gmcpAccountService.selectByBuyerId(user.getManBuyerId());
        if(gmcpAccount==null){
            return "brand-wallerAcountRegister";
        }

        //查询余额
        GmcFundDTO gmcFundDTO = gmcpAccountService.selectMoneyByBuyerId(gmcpAccount.getBuyerId());
        model.addAttribute("account",gmcFundDTO);
        return "brand-gmcwallerAcount";
    }



    //注册钱包
    @PostMapping("/mvo/gmc/register")
    @ResponseBody
    public Result registerGmc(HttpSession session, @RequestBody GmcpAccount gmcpAccount){
        try {
            SysUser user = (SysUser)session.getAttribute("user");
            gmcpAccount.setManBuyerId(user.getManBuyerId());
            gmcpAccount.setPassword(PasswordUtil.encryptedPasswordBySha256(gmcpAccount.getPassword()));
            gmcpAccountService.insertSelective(gmcpAccount);

            //插入gmc_fund
            GmcpAccountFund gmcpAccountFund=new GmcpAccountFund();
            gmcpAccountFund.setBuyerId(gmcpAccount.getBuyerId());
            gmcAccountFundService.insertSelective(gmcpAccountFund);

            return this.send(200,"注册成功");
        }catch (Exception e){
            e.printStackTrace();
            return this.send(-1,"操作失败");
        }
    }


    //提现
    @PostMapping("/mvo/gmc/deposit")
    @ResponseBody
    @Transactional
    public Result showMoney(HttpSession session, @RequestBody String str ){
        try{
            SysUser user = (SysUser)session.getAttribute("user");
            JSONObject object= JSON.parseObject(str);

            //账户id
            Integer buyerId = object.getInteger("buyerId");
            String accountName = object.getString("acName");
            //余额
            BigDecimal oldMoney = object.getBigDecimal("oldMoney");
            //提现金额
            BigDecimal money = object.getBigDecimal("money");
            String password = object.getString("password");

            //验证密码
            if(PasswordUtil.encryptedPasswordBySha256(password).equals(user.getPassword())){
                if(oldMoney.compareTo(money)==-1){
                    return this.send(-1,"余额不足，提现失败");
                }
                //提现
                gmcAccountFundService.depositMoney(oldMoney,money,buyerId,accountName);
            }else {
                return this.send(-1,"支付密码错误");
            }
            return this.send(200,"提现已提交，等待审核");
        }catch (Exception e){
            e.printStackTrace();
            return this.send(-1,"操作失败");
        }
    }


    //查看流水
    @GetMapping("/mvo/gmc/record")
    public String showRecord(HttpSession session,Model model,Integer id){

        List<RecordAuditDTO> recordAuditDTOS = gmcAccountFundService.selectRecordAndAudit(id);
        for(RecordAuditDTO record:recordAuditDTOS){
            if(record.getStatus().equals((byte)2)){
                record.setRemark("待审核");
            }else if(record.getStatus().equals((byte)4)){
                record.setRemark("完成");
            }else {
                record.setRemark("失败");
            }

            //业务类型 1-充值 2-提现 3-消费 4-退款
            if(record.getTransactionType().equals((byte)1)){
                record.setType("充值");
            }else if(record.getTransactionType().equals((byte)2)){
                record.setType("提现");
            }else if(record.getTransactionType().equals((byte)3)){
                record.setType("消费");
            }else {
                record.setType("退款");
            }

        }

        model.addAttribute("record",recordAuditDTOS);
        return "brand-gmcwallerAcountList";
    }
}
