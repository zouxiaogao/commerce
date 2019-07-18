package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.EbaEbayAuthorization;

public interface EbaEbayAuthorizationMapper {
    int deleteByPrimaryKey(Integer ebaId);

    int insert(EbaEbayAuthorization record);

    int insertSelective(EbaEbayAuthorization record);

    EbaEbayAuthorization selectByPrimaryKey(Integer ebaId);

    int updateByPrimaryKeySelective(EbaEbayAuthorization record);

    int updateByPrimaryKeyWithBLOBs(EbaEbayAuthorization record);

    int updateByPrimaryKey(EbaEbayAuthorization record);
}