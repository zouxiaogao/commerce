package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.SysAndorra;

public interface SysAndorraMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysAndorra record);

    int insertSelective(SysAndorra record);

    SysAndorra selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAndorra record);

    int updateByPrimaryKey(SysAndorra record);
}