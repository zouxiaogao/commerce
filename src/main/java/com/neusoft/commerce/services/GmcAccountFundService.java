package com.neusoft.commerce.services;

import com.neusoft.commerce.models.GmcpAccountFund;

import java.math.BigDecimal;

/**
 * @Author zqy
 * @Date 2019/08/01
 */
public interface GmcAccountFundService {
    int insert(GmcpAccountFund record);

    int insertSelective(GmcpAccountFund record);

    int updateMoney(BigDecimal money, Integer buyerId);

}
