package com.neusoft.commerce.ctrls.bvo;

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
 * @Date 2019/07/30
 */
@Controller
public class BvoProductCtrl {
    @Autowired
    private ProductServiceImpl productService;

//    @GetMapping("/bvo/product/index")
//    public String productIndex(){
//        return "bvo-index";
//    }


    @GetMapping("/bvo/index/productlist")
    public String bvoProduct(HttpServletRequest request, Model model){
        List<ProductDTO> productDTOS = productService.selectAllProduct();
        model.addAttribute("products",productDTOS);
        return "bvo-index";
    }


    //查看详情
    @GetMapping("/bvo/product/detail")
    public String productDetail(Integer id,Model model){
        ProductDTO productDTO = productService.selectProductByProId(id);
        model.addAttribute("product",productDTO);
        return "bvo-goodsdetail";
    }
}
