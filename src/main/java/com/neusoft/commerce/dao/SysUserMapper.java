package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.SysUser;
import com.neusoft.commerce.models.dto.BvoInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByAccount(@Param("username") String username);

    int updateManId(@Param("manId") Integer manId,@Param("userId") Integer userId);

    BvoInfoDTO selectBvoInfo(Integer userId);
}