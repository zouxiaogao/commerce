package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.StoStoreOrder;

public interface StoStoreOrderMapper {
    int deleteByPrimaryKey(Integer stoId);

    int insert(StoStoreOrder record);

    int insertSelective(StoStoreOrder record);

    StoStoreOrder selectByPrimaryKey(Integer stoId);

    int updateByPrimaryKeySelective(StoStoreOrder record);

    int updateByPrimaryKey(StoStoreOrder record);
}