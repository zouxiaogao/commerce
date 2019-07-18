package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.PrcProductCategory;

public interface PrcProductCategoryMapper {
    int deleteByPrimaryKey(Integer prcId);

    int insert(PrcProductCategory record);

    int insertSelective(PrcProductCategory record);

    PrcProductCategory selectByPrimaryKey(Integer prcId);

    int updateByPrimaryKeySelective(PrcProductCategory record);

    int updateByPrimaryKey(PrcProductCategory record);
}