package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.StrStore;
import com.neusoft.commerce.models.dto.DsrStoreDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StrStoreMapper {
    int deleteByPrimaryKey(Integer strId);

    int insert(StrStore record);

    int insertSelective(StrStore record);

    StrStore selectByPrimaryKey(Integer strId);

    int updateByPrimaryKeySelective(StrStore record);

    int updateByPrimaryKey(StrStore record);

    List<StrStore> selectStoreByDsrId(Integer dsrId);
}