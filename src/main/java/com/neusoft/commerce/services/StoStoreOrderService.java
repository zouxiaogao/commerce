package com.neusoft.commerce.services;

import com.neusoft.commerce.models.StoStoreOrder;

import java.util.List;

/**
 * @Author zqy
 * @Date 2019/08/02
 */
public interface StoStoreOrderService {

    int deleteByPrimaryKey(Integer stoId);

    int insert(StoStoreOrder record);

    int insertSelective(StoStoreOrder record);

    StoStoreOrder selectByPrimaryKey(Integer stoId);

    int updateByPrimaryKeySelective(StoStoreOrder record);

    int updateByPrimaryKey(StoStoreOrder record);

    List<StoStoreOrder> selectStoreOrderList(List<Integer> ids);
}
