package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.Max;
import java.util.List;

@Mapper
public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer menuId);

    List<SysMenu> selectByMenuIds(@Param("menuId") List<Integer> menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}