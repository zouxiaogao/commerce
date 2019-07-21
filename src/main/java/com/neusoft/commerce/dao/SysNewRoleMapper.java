package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.SysNewRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysNewRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SysNewRole record);

    int insertSelective(SysNewRole record);

    SysNewRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysNewRole record);

    int updateByPrimaryKey(SysNewRole record);
}