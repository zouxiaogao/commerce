package com.neusoft.commerce.ctrls;

import com.neusoft.commerce.models.ProProduct;
import com.neusoft.commerce.models.SysUser;
import com.neusoft.commerce.models.dto.ProductDTO;
import com.neusoft.commerce.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/19
 */
@Controller
public class BrandProductCtrl {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/brand-productInput-attr")
    public String brandProductattr(){
        return "/brand-productInput-attr";
    }


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
}
