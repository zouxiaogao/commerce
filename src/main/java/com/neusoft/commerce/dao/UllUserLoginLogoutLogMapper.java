package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.UllUserLoginLogoutLog;

public interface UllUserLoginLogoutLogMapper {
    int deleteByPrimaryKey(Integer ullId);

    int insert(UllUserLoginLogoutLog record);

    int insertSelective(UllUserLoginLogoutLog record);

    UllUserLoginLogoutLog selectByPrimaryKey(Integer ullId);

    int updateByPrimaryKeySelective(UllUserLoginLogoutLog record);

    int updateByPrimaryKey(UllUserLoginLogoutLog record);
}