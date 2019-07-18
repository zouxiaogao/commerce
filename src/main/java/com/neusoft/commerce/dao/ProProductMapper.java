package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.ProProduct;

public interface ProProductMapper {
    int deleteByPrimaryKey(Integer proId);

    int insert(ProProduct record);

    int insertSelective(ProProduct record);

    ProProduct selectByPrimaryKey(Integer proId);

    int updateByPrimaryKeySelective(ProProduct record);

    int updateByPrimaryKeyWithBLOBs(ProProduct record);

    int updateByPrimaryKey(ProProduct record);
}