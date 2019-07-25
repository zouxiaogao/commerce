package com.neusoft.commerce.ctrls;

import com.neusoft.commerce.common.Result;
import com.neusoft.commerce.models.ManManufacturer;
import com.neusoft.commerce.models.SysUser;
import com.neusoft.commerce.services.impl.ManManufacturerServiceImpl;
import com.neusoft.commerce.services.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Author zqy
 * @Date 2019/07/19
 */
@Controller
public class BrdBrandCtrl extends BaseCtrl{

    @Autowired
    private ManManufacturerServiceImpl manufacturerService;
    @Autowired
    private SysUserServiceImpl sysUserService;


    @GetMapping("/brand-addbrand")
    public String brand(HttpServletRequest request, Model model){
       try {
           SysUser user =(SysUser) request.getSession().getAttribute("user");
           if(user.getManBuyerId()==null){
               SysUser sysUser=sysUserService.selectByAccount(user.getUsername());
               ManManufacturer manManufacturer = manufacturerService.selectByPrimaryKey(sysUser.getManBuyerId());
               model.addAttribute("manManufacturer",manManufacturer);
               return "/brand-addbrand";
           }else {
               ManManufacturer manManufacturer = manufacturerService.selectByPrimaryKey(user.getManBuyerId());
               model.addAttribute("manManufacturer",manManufacturer);
               return "/brand-addbrand";
           }

       }catch (Exception e){
           e.printStackTrace();
           return "操作失败";
       }
    }


    @PostMapping("/saveBrand")
    @ResponseBody
    public Result saveBrand(@RequestBody ManManufacturer manufacturer, HttpServletRequest request){
        try {
            SysUser user =(SysUser) request.getSession().getAttribute("user");
            Integer num=0;
            if(manufacturer.getManId()!=null){  //update
                manufacturer.setCreatedBy(user.getUsername());
                num = manufacturerService.updateByPrimaryKey(manufacturer);
            }else { //insert
                manufacturer.setCreatedBy(user.getUsername());
                num=manufacturerService.insert(manufacturer);
                sysUserService.updateManId(manufacturer.getManId(),user.getUserId());
            }
            if(num>0){
                return this.send(200,"保存成功");
            }else {
                return this.send(-1,"保存失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return this.send(-1,"操作失败");
        }

    }
}
