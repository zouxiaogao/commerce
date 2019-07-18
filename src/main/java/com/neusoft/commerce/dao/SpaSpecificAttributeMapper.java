package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.SpaSpecificAttribute;

public interface SpaSpecificAttributeMapper {
    int deleteByPrimaryKey(Integer spaId);

    int insert(SpaSpecificAttribute record);

    int insertSelective(SpaSpecificAttribute record);

    SpaSpecificAttribute selectByPrimaryKey(Integer spaId);

    int updateByPrimaryKeySelective(SpaSpecificAttribute record);

    int updateByPrimaryKey(SpaSpecificAttribute record);
}