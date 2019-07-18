package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.BrdBrand;

public interface BrdBrandMapper {
    int deleteByPrimaryKey(Integer brdId);

    int insert(BrdBrand record);

    int insertSelective(BrdBrand record);

    BrdBrand selectByPrimaryKey(Integer brdId);

    int updateByPrimaryKeySelective(BrdBrand record);

    int updateByPrimaryKey(BrdBrand record);
}