package com.neusoft.commerce.ctrls.brand;

import com.neusoft.commerce.common.StringUtils;
import com.neusoft.commerce.models.SysMenu;
import com.neusoft.commerce.models.SysNewRole;
import com.neusoft.commerce.models.SysUser;
import com.neusoft.commerce.services.impl.SysMenuServiceImpl;
import com.neusoft.commerce.services.impl.SysNewRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/18
 */
@Controller
public class RenderCtrl {

    @Autowired
    private SysNewRoleServiceImpl sysNewRoleService;
    @Autowired
    private SysMenuServiceImpl sysMenuService;

    @GetMapping(value = {"/","/login"})
    public String console(){
        return "login";
    }


    @GetMapping("/index")
    public String console(HttpServletRequest httpServletRequest, Model model){
        SysUser user =(SysUser) httpServletRequest.getSession().getAttribute("user");
        if (user == null) {
           return "login";
        }else{
            //角色信息
            SysNewRole sysNewRole = sysNewRoleService.selectByPrimaryKey(Integer.parseInt(user.getRoleId()));
            String[] menu=StringUtils.splitTo(sysNewRole.getVisibleMenuId());
            List<Integer> menuIds = StringUtils.StringConvertInter(menu);
            //菜单信息
            List<SysMenu> sysMenus = sysMenuService.selectByMenuIds(menuIds);
            model.addAttribute("role",sysNewRole);
            model.addAttribute("menus",sysMenus);
            return "index";
        }
    }


//    @GetMapping(value = {"/index"})
//    public String index(){
//        return "index";
//    }





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
