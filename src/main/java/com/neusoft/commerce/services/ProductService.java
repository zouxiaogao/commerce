package com.neusoft.commerce.services;

import com.neusoft.commerce.models.ProProduct;
import com.neusoft.commerce.models.dto.ProductCategory;
import com.neusoft.commerce.models.dto.ProductDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/21
 */
public interface ProductService {
    int deleteByPrimaryKey(Integer proId);

    int insert(ProProduct record);

    int insertSelective(ProProduct record);

    ProProduct selectByPrimaryKey(Integer proId);

    int updateByPrimaryKeySelective(ProProduct record);

    int updateByPrimaryKeyWithBLOBs(ProProduct record);

    int updateByPrimaryKey(ProProduct record);

    List<ProductDTO> selectByManId(Integer manId);
    List<ProductDTO> selectAllByManId(Integer manId);


    List<ProductDTO> selectByManIdAndCondition(Integer manBuyerId,String tittle);

    ProductDTO selectByProId(Integer proId);

    int updateProduct(ProductDTO productDTO,String name);
    int insertProduct(ProductDTO productDTO,String name);

    int deleteByProduct(Integer id);
    int updateProductRepo(Integer proId);


    List<ProductCategory> selectProductCategory(@Param("manId") Integer manId);
    ProductCategory selectProductCategoryDetail(@Param("proId") Integer proId);

    List<ProductDTO> selectAllProduct();

    //已上架
    ProductDTO selectProductByProId(Integer proId);


}
