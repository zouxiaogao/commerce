package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.MorMonitorResult;

public interface MorMonitorResultMapper {
    int deleteByPrimaryKey(Integer morId);

    int insert(MorMonitorResult record);

    int insertSelective(MorMonitorResult record);

    MorMonitorResult selectByPrimaryKey(Integer morId);

    int updateByPrimaryKeySelective(MorMonitorResult record);

    int updateByPrimaryKey(MorMonitorResult record);
}