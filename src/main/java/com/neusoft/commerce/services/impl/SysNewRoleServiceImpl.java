package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.SysNewRoleMapper;
import com.neusoft.commerce.models.SysNewRole;
import com.neusoft.commerce.services.SysNewRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zqy
 * @Date 2019/07/21
 */
@Service
public class SysNewRoleServiceImpl implements SysNewRoleService {

    @Autowired
    private SysNewRoleMapper sysNewRoleMapper;


    @Override
    public int deleteByPrimaryKey(Integer roleId) {
        return 0;
    }

    @Override
    public int insert(SysNewRole record) {
        return 0;
    }

    @Override
    public int insertSelective(SysNewRole record) {
        return 0;
    }

    @Override
    public SysNewRole selectByPrimaryKey(Integer roleId) {
        return sysNewRoleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysNewRole record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysNewRole record) {
        return 0;
    }
}
