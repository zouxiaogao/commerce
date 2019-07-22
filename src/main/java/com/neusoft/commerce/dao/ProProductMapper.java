package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.ProProduct;
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

    List<ProductDTO> selectByManId(@Param("manId") Integer manId);
    List<ProductDTO> selectByManIdAndCondition(@Param("manId") Integer manBuyerId,@Param("tittle") String tittle);
}