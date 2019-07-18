package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.SpvSpecificAttributeValue;

public interface SpvSpecificAttributeValueMapper {
    int deleteByPrimaryKey(Integer spvId);

    int insert(SpvSpecificAttributeValue record);

    int insertSelective(SpvSpecificAttributeValue record);

    SpvSpecificAttributeValue selectByPrimaryKey(Integer spvId);

    int updateByPrimaryKeySelective(SpvSpecificAttributeValue record);

    int updateByPrimaryKey(SpvSpecificAttributeValue record);
}