package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.GmcpTransactionAudit;

public interface GmcpTransactionAuditMapper {
    int deleteByPrimaryKey(Integer transactionAuditId);

    int insert(GmcpTransactionAudit record);

    int insertSelective(GmcpTransactionAudit record);

    GmcpTransactionAudit selectByPrimaryKey(Integer transactionAuditId);

    int updateByPrimaryKeySelective(GmcpTransactionAudit record);

    int updateByPrimaryKey(GmcpTransactionAudit record);
}