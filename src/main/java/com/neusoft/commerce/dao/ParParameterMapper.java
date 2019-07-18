package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.ParParameter;

public interface ParParameterMapper {
    int deleteByPrimaryKey(Integer parId);

    int insert(ParParameter record);

    int insertSelective(ParParameter record);

    ParParameter selectByPrimaryKey(Integer parId);

    int updateByPrimaryKeySelective(ParParameter record);

    int updateByPrimaryKeyWithBLOBs(ParParameter record);

    int updateByPrimaryKey(ParParameter record);
}