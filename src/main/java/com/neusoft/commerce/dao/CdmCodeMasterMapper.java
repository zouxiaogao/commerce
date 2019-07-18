package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.CdmCodeMaster;

public interface CdmCodeMasterMapper {
    int deleteByPrimaryKey(Integer cdmId);

    int insert(CdmCodeMaster record);

    int insertSelective(CdmCodeMaster record);

    CdmCodeMaster selectByPrimaryKey(Integer cdmId);

    int updateByPrimaryKeySelective(CdmCodeMaster record);

    int updateByPrimaryKey(CdmCodeMaster record);
}