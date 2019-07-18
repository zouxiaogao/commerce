package com.neusoft.commerce.services;

import com.neusoft.commerce.models.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zqy
 * @Date 2019/07/18
 */
public interface SysUserService {

    SysUser selectByAccount(String username);
    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}
