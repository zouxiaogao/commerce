package com.neusoft.commerce.services;

import com.neusoft.commerce.models.SolStoreOrderLineItem;

/**
 * @Author zqy
 * @Date 2019/08/03
 */
public interface SolStoreOrderLineItemService {
    int deleteByPrimaryKey(Integer solId);

    int insert(SolStoreOrderLineItem record);

    int insertSelective(SolStoreOrderLineItem record);

    SolStoreOrderLineItem selectByPrimaryKey(Integer solId);

    int updateByPrimaryKeySelective(SolStoreOrderLineItem record);

    int updateByPrimaryKeyWithBLOBs(SolStoreOrderLineItem record);

    int updateByPrimaryKey(SolStoreOrderLineItem record);
}
