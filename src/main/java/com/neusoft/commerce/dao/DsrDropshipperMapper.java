package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.DsrDropshipper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DsrDropshipperMapper {
    int deleteByPrimaryKey(Integer dsrId);

    int insert(DsrDropshipper record);

    int insertSelective(DsrDropshipper record);

    DsrDropshipper selectByPrimaryKey(Integer dsrId);

    int updateByPrimaryKeySelective(DsrDropshipper record);

    int updateByPrimaryKey(DsrDropshipper record);
}