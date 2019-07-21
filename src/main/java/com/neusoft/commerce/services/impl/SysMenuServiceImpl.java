package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.SysMenuMapper;
import com.neusoft.commerce.models.SysMenu;
import com.neusoft.commerce.services.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/21
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public int deleteByPrimaryKey(Integer menuId) {
        return 0;
    }

    @Override
    public int insert(SysMenu record) {
        return 0;
    }

    @Override
    public int insertSelective(SysMenu record) {
        return 0;
    }

    @Override
    public SysMenu selectByPrimaryKey(Integer menuId) {
        return null;
    }

    @Override
    public List<SysMenu> selectByMenuIds(List<Integer> menuId) {
        return sysMenuMapper.selectByMenuIds(menuId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysMenu record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysMenu record) {
        return 0;
    }
}
