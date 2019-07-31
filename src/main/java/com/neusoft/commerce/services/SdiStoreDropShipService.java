package com.neusoft.commerce.services;

import com.neusoft.commerce.models.SdiStoreDropshipItem;

/**
 * @Author zqy
 * @Date 2019/07/31
 */
public interface SdiStoreDropShipService {
    int deleteByPrimaryKey(Integer dilId);

    int insert(SdiStoreDropshipItem record);

    int insertSelective(SdiStoreDropshipItem record);

    SdiStoreDropshipItem selectByPrimaryKey(Integer dilId);

    int updateByPrimaryKeySelective(SdiStoreDropshipItem record);

    int updateByPrimaryKey(SdiStoreDropshipItem record);
}
