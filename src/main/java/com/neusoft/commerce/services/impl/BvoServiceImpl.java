package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.StrStoreMapper;
import com.neusoft.commerce.models.StrStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/30
 */

@Service
public class BvoServiceImpl {

    @Autowired
    private StrStoreMapper strStoreMapper;

    public List<StrStore> selectStoreByDsrId(Integer dsrId){
        return strStoreMapper.selectStoreByDsrId(dsrId);
    }
}
