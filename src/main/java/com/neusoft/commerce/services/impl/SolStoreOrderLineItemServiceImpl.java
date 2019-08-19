package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.SolStoreOrderLineItemMapper;
import com.neusoft.commerce.models.SolStoreOrderLineItem;
import com.neusoft.commerce.services.SolStoreOrderLineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zqy
 * @Date 2019/08/03
 */
@Service
public class SolStoreOrderLineItemServiceImpl implements SolStoreOrderLineItemService {

    @Autowired
    private SolStoreOrderLineItemMapper solStoreOrderLineItemMapper;


    @Override
    public int deleteByPrimaryKey(Integer solId) {
        return 0;
    }

    @Override
    public int insert(SolStoreOrderLineItem record) {
        return solStoreOrderLineItemMapper.insert(record);
    }

    @Override
    public int insertSelective(SolStoreOrderLineItem record) {
        return solStoreOrderLineItemMapper.insertSelective(record);
    }

    @Override
    public SolStoreOrderLineItem selectByPrimaryKey(Integer solId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(SolStoreOrderLineItem record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(SolStoreOrderLineItem record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SolStoreOrderLineItem record) {
        return 0;
    }
}
