package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.StrStore;

public interface StrStoreMapper {
    int deleteByPrimaryKey(Integer strId);

    int insert(StrStore record);

    int insertSelective(StrStore record);

    StrStore selectByPrimaryKey(Integer strId);

    int updateByPrimaryKeySelective(StrStore record);

    int updateByPrimaryKey(StrStore record);
}