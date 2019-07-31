package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.ProProduct;
import com.neusoft.commerce.models.dto.ProductCategory;
import com.neusoft.commerce.models.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProProductMapper {
    int deleteByPrimaryKey(Integer proId);

    int insert(ProProduct record);

    int insertSelective(ProProduct record);

    ProProduct selectByPrimaryKey(Integer proId);

    ProductDTO selectByProId(Integer proId);

    int updateByPrimaryKeySelective(ProProduct record);

    int updateByPrimaryKeyWithBLOBs(ProProduct record);

    int updateByPrimaryKey(@Param("product") ProProduct record);

    List<ProductCategory> selectProductCategory(@Param("manId") Integer manId);

    ProductCategory selectProductCategoryDetail(@Param("proId") Integer proId);


    //不查已删除
    List<ProductDTO> selectAllByManId(@Param("manId") Integer manId);

    //只查上架
    List<ProductDTO> selectByManId(@Param("manId") Integer manId);
    List<ProductDTO> selectByManIdAndCondition(@Param("manId") Integer manBuyerId,@Param("tittle") String tittle);
    int deleteProductById(Integer proId);

    int updateProductRepo(Integer proId);

    List<ProductDTO> selectAllProduct();

    //已上架
    ProductDTO selectProductByProId(Integer proId);
}