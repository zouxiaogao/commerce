package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.SalSalesOrderLineItem;

public interface SalSalesOrderLineItemMapper {
    int deleteByPrimaryKey(Integer salId);

    int insert(SalSalesOrderLineItem record);

    int insertSelective(SalSalesOrderLineItem record);

    SalSalesOrderLineItem selectByPrimaryKey(Integer salId);

    int updateByPrimaryKeySelective(SalSalesOrderLineItem record);

    int updateByPrimaryKey(SalSalesOrderLineItem record);
}