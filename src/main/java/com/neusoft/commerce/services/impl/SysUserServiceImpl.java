package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.SysUserMapper;
import com.neusoft.commerce.models.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zqy
 * @Date 2019/07/18
 */
@Service
public class SysUserServiceImpl implements SysUserMapper {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return 0;
    }

    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return 0;
    }

    @Override
    public SysUser selectByPrimaryKey(Integer userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return 0;
    }

    @Override
    public SysUser selectByAccount(String username) {
        return sysUserMapper.selectByAccount(username);
    }

    @Override
    public int updateManId(Integer manId, Integer userId) {
        return sysUserMapper.updateManId(manId,userId);
    }
}
