package com.neusoft.commerce.services;

import com.neusoft.commerce.models.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/21
 */
public interface SysMenuService {
    int deleteByPrimaryKey(Integer menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer menuId);

    List<SysMenu> selectByMenuIds(@Param("menuId") List<Integer> menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}
