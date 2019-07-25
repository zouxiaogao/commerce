package com.neusoft.commerce.ctrls;

import com.neusoft.commerce.common.PasswordUtil;
import com.neusoft.commerce.common.Result;
import com.neusoft.commerce.models.SysUser;
import com.neusoft.commerce.services.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author zqy
 * @Date 2019/07/25
 */
@Controller
public class RegisterCtrl extends BaseCtrl{

    @Autowired
    private SysUserServiceImpl sysUserService;


    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestBody SysUser sysUser){
        try {
            if(sysUser==null){
                return this.send(-1,"请完善注册信息");
            }

            SysUser user = sysUserService.selectByAccount(sysUser.getUsername());
            if(user!=null){
                return this.send(-1,"用户名已存在");
            }
            //密码加密
            sysUser.setPassword(PasswordUtil.encryptedPasswordBySha256(sysUser.getPassword()));
            sysUserService.insert(sysUser);
            return this.send(200,"注册成功");
        }catch (Exception e){
            return this.send(-1,"注册失败");
        }
    }
}
