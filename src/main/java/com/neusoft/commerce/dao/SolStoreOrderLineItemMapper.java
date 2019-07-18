package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.SolStoreOrderLineItem;

public interface SolStoreOrderLineItemMapper {
    int deleteByPrimaryKey(Integer solId);

    int insert(SolStoreOrderLineItem record);

    int insertSelective(SolStoreOrderLineItem record);

    SolStoreOrderLineItem selectByPrimaryKey(Integer solId);

    int updateByPrimaryKeySelective(SolStoreOrderLineItem record);

    int updateByPrimaryKeyWithBLOBs(SolStoreOrderLineItem record);

    int updateByPrimaryKey(SolStoreOrderLineItem record);
}