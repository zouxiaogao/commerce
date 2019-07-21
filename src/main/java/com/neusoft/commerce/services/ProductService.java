package com.neusoft.commerce.services;

import com.neusoft.commerce.models.ProProduct;
import com.neusoft.commerce.models.dto.ProductDTO;

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

    List<ProductDTO> selectByManIdAndCondition(Integer manBuyerId,String tittle);

    ProductDTO selectByProId(Integer proId);
}
