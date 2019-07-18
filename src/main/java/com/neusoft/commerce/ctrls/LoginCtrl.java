package com.neusoft.commerce.ctrls;

import com.neusoft.commerce.common.PasswordUtil;
import com.neusoft.commerce.common.Result;
import com.neusoft.commerce.models.SysUser;
import com.neusoft.commerce.services.SysUserService;
import com.neusoft.commerce.services.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author zqy
 * @Date 2019/07/18
 */
@Controller
public class LoginCtrl extends BaseCtrl{

    @Autowired
    private SysUserServiceImpl sysUserService;


    @PostMapping(value = { "/checklogin" })
    @ResponseBody
    public Result checklogin(HttpServletRequest request, String name, String password) {
        System.out.println(111);
        try {
            SysUser sysUser = sysUserService.selectByAccount(name);
            System.out.println(PasswordUtil.encryptedPasswordBySha256(password));
            if(sysUser!=null&&sysUser.getPassword().equals(PasswordUtil.encryptedPasswordBySha256(password))){
                request.getSession().setAttribute("user",sysUser);
                return this.send(200,"登录成功",sysUser);
            }else {
                return this.send(-1,"用户名或密码错误");
            }

        }catch (Exception e){
            e.printStackTrace();
            return this.send(-1,"操作失败");
        }
    }
}
