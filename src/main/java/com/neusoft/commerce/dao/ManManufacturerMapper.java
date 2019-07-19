package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.ManManufacturer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManManufacturerMapper {
    int deleteByPrimaryKey(Integer manId);

    int insert(ManManufacturer record);

    int insertSelective(ManManufacturer record);

    ManManufacturer selectByPrimaryKey(Integer manId);

    int updateByPrimaryKeySelective(ManManufacturer record);

    int updateByPrimaryKeyWithBLOBs(ManManufacturer record);

    int updateByPrimaryKey(ManManufacturer record);
}