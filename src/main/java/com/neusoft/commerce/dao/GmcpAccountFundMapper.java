package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.GmcpAccountFund;

public interface GmcpAccountFundMapper {
    int insert(GmcpAccountFund record);

    int insertSelective(GmcpAccountFund record);
}