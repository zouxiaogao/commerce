package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.GoaGovernmentArea;

public interface GoaGovernmentAreaMapper {
    int deleteByPrimaryKey(Integer goaId);

    int insert(GoaGovernmentArea record);

    int insertSelective(GoaGovernmentArea record);

    GoaGovernmentArea selectByPrimaryKey(Integer goaId);

    int updateByPrimaryKeySelective(GoaGovernmentArea record);

    int updateByPrimaryKey(GoaGovernmentArea record);
}