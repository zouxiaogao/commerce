package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.SalSalesOrderLineItemMapper;
import com.neusoft.commerce.models.SalSalesOrderLineItem;
import com.neusoft.commerce.services.SalSalesOrderLineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zqy
 * @Date 2019/08/03
 */
@Service
public class SalSalesOrderLineItemServiceImpl implements SalSalesOrderLineItemService {
    @Autowired
    private SalSalesOrderLineItemMapper salesOrderLineItemMapper;


    @Override
    public int deleteByPrimaryKey(Integer salId) {
        return 0;
    }

    @Override
    public int insert(SalSalesOrderLineItem record) {
        return salesOrderLineItemMapper.insert(record);
    }

    @Override
    public int insertSelective(SalSalesOrderLineItem record) {
        return salesOrderLineItemMapper.insertSelective(record);
    }

    @Override
    public SalSalesOrderLineItem selectByPrimaryKey(Integer salId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(SalSalesOrderLineItem record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SalSalesOrderLineItem record) {
        return 0;
    }
}
