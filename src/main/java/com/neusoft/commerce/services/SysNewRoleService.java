package com.neusoft.commerce.services;

import com.neusoft.commerce.models.SysNewRole;

/**
 * @Author zqy
 * @Date 2019/07/21
 */
public interface SysNewRoleService {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SysNewRole record);

    int insertSelective(SysNewRole record);

    SysNewRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysNewRole record);

    int updateByPrimaryKey(SysNewRole record);
}
