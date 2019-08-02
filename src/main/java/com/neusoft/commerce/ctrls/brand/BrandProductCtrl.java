package com.neusoft.commerce.ctrls.brand;

import com.neusoft.commerce.common.Result;
import com.neusoft.commerce.ctrls.BaseCtrl;
import com.neusoft.commerce.models.*;
import com.neusoft.commerce.models.dto.ProductCategory;
import com.neusoft.commerce.models.dto.ProductDTO;
import com.neusoft.commerce.services.impl.ProductServiceImpl;
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
public class BrandProductCtrl extends BaseCtrl {

    @Autowired
    private ProductServiceImpl productService;


    /**********************商品管理**************************/
    @GetMapping("/product/showProductList")
    public String showProductList() {
        return "brand-productInput-pic";
    }

    @GetMapping("/product/productlist")
    public String productList(HttpServletRequest request, Model model) {
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        List<ProductCategory> productCategories = productService.selectProductCategory(user.getManBuyerId());
        for (ProductCategory productCategory : productCategories) {
            if (productCategory.getStsCd().equals("I")) {
                productCategory.setStsCd("待上架");
            } else if (productCategory.getStsCd().equals("A")) {
                productCategory.setStsCd("上架中");
            } else if (productCategory.getStsCd().equals("W")) {
                productCategory.setStsCd("入仓中");
            } else if (productCategory.getStsCd().equals("S")) {
                productCategory.setStsCd("待入仓");
            } else {
                productCategory.setStsCd("待入仓");
            }
        }
        model.addAttribute("products", productCategories);
        return "brand-productInput-pic";
    }


//    //修改页面
//    @GetMapping("/product/productlist/detail")
//    public String getProductDetail(Integer id, Model model){
//        ProductCategory productCategory = productService.selectProductCategoryDetail(id);
//        model.addAttribute("datail",productCategory);
//        return "brand-productInput-pic";
//    }


    @PostMapping("/product/productlist/save")
    @ResponseBody
    public Result productSave(@RequestBody ProductCategory productCategory) {
        try {

            //查询分类
            PrcProductCategory category = productService.selectCategory(productCategory.getProId());

            if (category == null) {
                productService.insertProductCategory(productCategory);
            } else {
                productCategory.setPrcId(category.getPrcId());
                productService.updateProductCategory(productCategory);
            }


            return this.send(200, "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return this.send(-1, "操作失败");
        }
    }


    //入仓
    @GetMapping("/product/productlist/goRepo")
    @ResponseBody
    public Result goRepo(Integer id) {
        try {
            ProProduct product = productService.selectByPrimaryKey(id);
            if (product.getStsCd().equals("W")) {
                return this.send(-1, "以入仓，请不要重复操作");
            }
            productService.updateProductRepo(id);
            return this.send(200, "入仓成功");
        } catch (Exception e) {
            e.printStackTrace();
            return this.send(-1, "操作失败");
        }
    }


    /***********************商品录入*****************************/

    @GetMapping("/brand-productInput-attr")
    public String brandProductattr() {
        return "/brand-productInput-attr";
    }


    @GetMapping("/brand-productInput-attr/productlist")
    public String brandProduct(HttpServletRequest request, Model model) {
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        List<ProductDTO> productDTOS = productService.selectByManId(user.getManBuyerId());
        model.addAttribute("products", productDTOS);
        return "brand-productInput-attr::productlist";
    }

    @GetMapping("/brand-productInput-attr/search")
    public String brandProductSearch(HttpServletRequest request, Model model, String tittle) {
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        model.addAttribute("products", productService.selectByManIdAndCondition(user.getManBuyerId(), tittle));
        return "brand-productInput-attr::productlist";
    }


    //修改页面
    @Transactional
    @GetMapping("/brand-productInput-attr2/detail")
    public String updateProduct(Integer id, Model model) {
        ProductDTO productDTO = productService.selectByProId(id);
        model.addAttribute("product", productDTO);
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
    public Result brandProductSave(HttpServletRequest request, @RequestBody ProductDTO productDTO) {
        try {
            SysUser user = (SysUser) request.getSession().getAttribute("user");
            productDTO.setManId(user.getManBuyerId());
            //SysNewRole sysNewRole = sysNewRoleService.selectByPrimaryKey(Integer.parseInt(user.getRoleId()));
            if (productDTO.getProId() != null) {  //update
                productService.updateProduct(productDTO, user.getName());
                return this.send(200, "修改成功");
            } else { //insert
                productService.insertProduct(productDTO, user.getName());
                return this.send(200, "新增成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return this.send(-1, "操作失败");
        }
    }


    //删除
    @GetMapping("/brand-productInput-attr/delete")
    @ResponseBody
    public Result delete(Integer id) {
        try {
            //productService.deleteByPrimaryKey(id);
            productService.deleteByProduct(id);
            return this.send(200, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return this.send(-1, "操作失败");
        }
    }
}
