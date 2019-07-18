package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.SdiStoreDropshipItem;

public interface SdiStoreDropshipItemMapper {
    int deleteByPrimaryKey(Integer dilId);

    int insert(SdiStoreDropshipItem record);

    int insertSelective(SdiStoreDropshipItem record);

    SdiStoreDropshipItem selectByPrimaryKey(Integer dilId);

    int updateByPrimaryKeySelective(SdiStoreDropshipItem record);

    int updateByPrimaryKey(SdiStoreDropshipItem record);
}