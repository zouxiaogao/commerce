package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.SaoSalesOrder;

public interface SaoSalesOrderMapper {
    int deleteByPrimaryKey(Integer saoId);

    int insert(SaoSalesOrder record);

    int insertSelective(SaoSalesOrder record);

    SaoSalesOrder selectByPrimaryKey(Integer saoId);

    int updateByPrimaryKeySelective(SaoSalesOrder record);

    int updateByPrimaryKeyWithBLOBs(SaoSalesOrder record);

    int updateByPrimaryKey(SaoSalesOrder record);
}