package com.neusoft.commerce.ctrls;

import com.neusoft.commerce.common.Result;
import com.neusoft.commerce.models.*;
import com.neusoft.commerce.models.dto.ProductDTO;
import com.neusoft.commerce.services.impl.ProductServiceImpl;
import com.neusoft.commerce.services.impl.SysNewRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/19
 */
@Controller
public class BrandProductCtrl extends BaseCtrl{

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/brand-productInput-attr")
    public String brandProductattr(){
        return "/brand-productInput-attr";
    }

    /************商品录入******************/
    @GetMapping("/brand-productInput-attr/productlist")
    public String brandProduct(HttpServletRequest request, Model model){
        SysUser user =(SysUser) request.getSession().getAttribute("user");
        List<ProductDTO> productDTOS = productService.selectByManId(user.getManBuyerId());
        model.addAttribute("products",productDTOS);
        return "brand-productInput-attr::productlist";
    }

    @GetMapping("/brand-productInput-attr/search")
    public String brandProductSearch(HttpServletRequest request, Model model,String tittle){
        SysUser user =(SysUser) request.getSession().getAttribute("user");
        model.addAttribute("products",productService.selectByManIdAndCondition(user.getManBuyerId(),tittle));
        return "brand-productInput-attr::productlist";
    }


    //修改页面
    @Transactional
    @GetMapping("/brand-productInput-attr2/detail")
    public String updateProduct(Integer id,Model model) {
        ProductDTO productDTO = productService.selectByProId(id);
        model.addAttribute("product",productDTO);
        return "/brand-productInput-attr2";
    }

    //新增页面
    @GetMapping("/brand-productInput-attr2")
    public String addProduct() {
        return "/brand-productInput-attr2";
    }



    @Transactional
    @PostMapping("/brand-productInput-attr/save")
    @ResponseBody
    public Result brandProductSave(HttpServletRequest request,@RequestBody ProductDTO productDTO){
        try {
            SysUser user =(SysUser) request.getSession().getAttribute("user");
            productDTO.setManId(user.getManBuyerId());
            //SysNewRole sysNewRole = sysNewRoleService.selectByPrimaryKey(Integer.parseInt(user.getRoleId()));
            if(productDTO.getProId()!=null){  //update
                productService.updateProduct(productDTO,user.getName());
                return this.send(200,"修改成功");
            }else { //insert
                productService.insertProduct(productDTO,user.getName());
                return this.send(200,"新增成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            return this.send(-1,"操作失败");
        }
    }


    //删除
    @GetMapping("/brand-productInput-attr/delete")
    @ResponseBody
    public Result delete(Integer id) {


        try {
            //productService.deleteByPrimaryKey(id);
            productService.deleteByProduct(id);
            return this.send(200,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return this.send(-1,"操作失败");
        }
    }




    /**********************商品管理**************************/
    @GetMapping("/product/showProductList")
    public String showProductList(){
        return "brand-productInput-pic";
    }
}
