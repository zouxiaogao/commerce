package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.GmcpTransactionRecord;

public interface GmcpTransactionRecordMapper {
    int deleteByPrimaryKey(Integer transactionId);

    int insert(GmcpTransactionRecord record);

    int insertSelective(GmcpTransactionRecord record);

    GmcpTransactionRecord selectByPrimaryKey(Integer transactionId);

    int updateByPrimaryKeySelective(GmcpTransactionRecord record);

    int updateByPrimaryKey(GmcpTransactionRecord record);
}