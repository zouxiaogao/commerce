package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.DrpDropshipPrice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrpDropshipPriceMapper {
    int deleteByPrimaryKey(Integer drpId);

    int insert(DrpDropshipPrice record);

    int insertSelective(DrpDropshipPrice record);

    DrpDropshipPrice selectByPrimaryKey(Integer drpId);

    int updateByPrimaryKeySelective(DrpDropshipPrice record);

    int updateByPrimaryKey(DrpDropshipPrice record);
}