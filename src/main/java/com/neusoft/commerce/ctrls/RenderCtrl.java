package com.neusoft.commerce.ctrls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zqy
 * @Date 2019/07/18
 */
@Controller
public class RenderCtrl {

    @GetMapping(value = {"/","/login"})
    public String console(){
        return "login";
    }

    @GetMapping(value = {"/index"})
    public String index(){
        return "index";
    }





//    @RequestMapping("/admin")
//    public ModelAndView admin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
//        AdminInfo admin = this.getAdminInfoFromSession(httpServletRequest);
//        if(admin == null){
//            try {
//                httpServletResponse.sendRedirect("/login/admin");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//        return this.render("admin",null);
//    }
}
