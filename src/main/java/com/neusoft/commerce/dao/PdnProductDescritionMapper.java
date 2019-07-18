package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.PdnProductDescrition;

public interface PdnProductDescritionMapper {
    int deleteByPrimaryKey(Integer pdnId);

    int insert(PdnProductDescrition record);

    int insertSelective(PdnProductDescrition record);

    PdnProductDescrition selectByPrimaryKey(Integer pdnId);

    int updateByPrimaryKeySelective(PdnProductDescrition record);

    int updateByPrimaryKeyWithBLOBs(PdnProductDescrition record);

    int updateByPrimaryKey(PdnProductDescrition record);
}