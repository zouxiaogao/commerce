package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.GmcpTransactionRecord;
import com.neusoft.commerce.models.dto.RecordAuditDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GmcpTransactionRecordMapper {
    int deleteByPrimaryKey(Integer transactionId);

    int insert(GmcpTransactionRecord record);

    int insertSelective(GmcpTransactionRecord record);

    GmcpTransactionRecord selectByPrimaryKey(Integer transactionId);

    int updateByPrimaryKeySelective(GmcpTransactionRecord record);

    int updateByPrimaryKey(GmcpTransactionRecord record);
    List<RecordAuditDTO> selectRecordAndAudit(@Param("buyerId") Integer buyerId);
}