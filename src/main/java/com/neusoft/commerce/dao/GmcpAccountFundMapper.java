package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.GmcpAccountFund;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface GmcpAccountFundMapper {
    int insert(GmcpAccountFund record);

    int insertSelective(GmcpAccountFund record);
    int updateMoney(@Param("money") BigDecimal money, @Param("buyerId")Integer buyerId);

}