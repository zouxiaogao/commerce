package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.PckPackageInfo;

public interface PckPackageInfoMapper {
    int deleteByPrimaryKey(Integer pckId);

    int insert(PckPackageInfo record);

    int insertSelective(PckPackageInfo record);

    PckPackageInfo selectByPrimaryKey(Integer pckId);

    int updateByPrimaryKeySelective(PckPackageInfo record);

    int updateByPrimaryKey(PckPackageInfo record);
}