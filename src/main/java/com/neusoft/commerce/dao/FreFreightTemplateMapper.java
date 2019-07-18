package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.FreFreightTemplate;

public interface FreFreightTemplateMapper {
    int deleteByPrimaryKey(Integer freId);

    int insert(FreFreightTemplate record);

    int insertSelective(FreFreightTemplate record);

    FreFreightTemplate selectByPrimaryKey(Integer freId);

    int updateByPrimaryKeySelective(FreFreightTemplate record);

    int updateByPrimaryKey(FreFreightTemplate record);
}