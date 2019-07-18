package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.GmcpAccount;

public interface GmcpAccountMapper {
    int deleteByPrimaryKey(Integer buyerId);

    int insert(GmcpAccount record);

    int insertSelective(GmcpAccount record);

    GmcpAccount selectByPrimaryKey(Integer buyerId);

    int updateByPrimaryKeySelective(GmcpAccount record);

    int updateByPrimaryKey(GmcpAccount record);
}