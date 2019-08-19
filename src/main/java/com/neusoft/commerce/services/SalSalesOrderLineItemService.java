package com.neusoft.commerce.services;

import com.neusoft.commerce.models.SalSalesOrderLineItem;

/**
 * @Author zqy
 * @Date 2019/08/03
 */
public interface SalSalesOrderLineItemService {
    int deleteByPrimaryKey(Integer salId);

    int insert(SalSalesOrderLineItem record);

    int insertSelective(SalSalesOrderLineItem record);

    SalSalesOrderLineItem selectByPrimaryKey(Integer salId);

    int updateByPrimaryKeySelective(SalSalesOrderLineItem record);

    int updateByPrimaryKey(SalSalesOrderLineItem record);
}
