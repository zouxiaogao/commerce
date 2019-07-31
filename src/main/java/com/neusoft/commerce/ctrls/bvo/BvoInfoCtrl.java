package com.neusoft.commerce.ctrls.bvo;

import com.neusoft.commerce.common.Result;
import com.neusoft.commerce.ctrls.BaseCtrl;
import com.neusoft.commerce.models.DsrDropshipper;
import com.neusoft.commerce.models.StrStore;
import com.neusoft.commerce.models.SysUser;
import com.neusoft.commerce.models.dto.BvoInfoDTO;
import com.neusoft.commerce.services.StroeServiceImpl;
import com.neusoft.commerce.services.impl.BvoServiceImpl;
import com.neusoft.commerce.services.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zqy
 * @Date 2019/07/29
 */
@Controller
public class BvoInfoCtrl extends BaseCtrl {


    @Autowired
    private SysUserServiceImpl sysUserService;
    @Autowired
    private BvoServiceImpl bvoServiceImpl;
    @Autowired
    private StroeServiceImpl stroeService;


    @GetMapping("/bvo/info")
    public String bvoInfo(HttpSession session,Model model){
        SysUser user = (SysUser)session.getAttribute("user");
        BvoInfoDTO bvo = sysUserService.selectBvoInfo(user.getUserId());
        model.addAttribute("bvo",bvo);

        return "bvo-myInfo";
    }


    //修改借卖方个人信息
    @PostMapping("/bvo/updateInfo")
    @ResponseBody
    public Result updateInfo(@RequestBody BvoInfoDTO bvo,HttpSession session){
        try {

            int i = sysUserService.updateBvoInfo(bvo);
            if(i>0){
                return this.send(200,"修改成功");
            }else {
                return this.send(-1,"修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return this.send(-1,"操作失败");
        }
    }



}
