package com.neusoft.commerce.services;

import com.neusoft.commerce.models.GmcpAccount;
import com.neusoft.commerce.models.dto.GmcFundDTO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author zqy
 * @Date 2019/08/01
 */
public interface GmcpAccountService {
    int deleteByPrimaryKey(Integer buyerId);

    int insert(GmcpAccount record);

    int insertSelective(GmcpAccount record);

    GmcpAccount selectByPrimaryKey(Integer buyerId);

    int updateByPrimaryKeySelective(GmcpAccount record);

    int updateByPrimaryKey(GmcpAccount record);

    //buyerId
    GmcpAccount selectByBuyerId(Integer buyerId);
    GmcFundDTO selectMoneyByBuyerId(Integer buyerId);



}
