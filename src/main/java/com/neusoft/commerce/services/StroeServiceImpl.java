package com.neusoft.commerce.services;

import com.neusoft.commerce.dao.StrStoreMapper;
import com.neusoft.commerce.models.StrStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zqy
 * @Date 2019/07/30
 */
@Service
public class StroeServiceImpl {
    @Autowired
    private StrStoreMapper strStoreMapper;

    public int insert(StrStore record){
        return 1;
    }

    public int insertSelective(StrStore record){
        return strStoreMapper.insertSelective(record);
    }
}
