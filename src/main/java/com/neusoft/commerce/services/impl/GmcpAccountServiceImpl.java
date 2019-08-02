package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.GmcpAccountMapper;
import com.neusoft.commerce.models.GmcpAccount;
import com.neusoft.commerce.models.dto.GmcFundDTO;
import com.neusoft.commerce.services.GmcpAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zqy
 * @Date 2019/08/01
 */
@Service
public class GmcpAccountServiceImpl implements GmcpAccountService {

    @Autowired
    private GmcpAccountMapper gmcpAccountMapper;

    @Override
    public int deleteByPrimaryKey(Integer buyerId) {
        return 0;
    }

    @Override
    public int insert(GmcpAccount record) {
        return 0;
    }

    @Override
    public int insertSelective(GmcpAccount record) {
        return gmcpAccountMapper.insertSelective(record);
    }

    @Override
    public GmcpAccount selectByPrimaryKey(Integer buyerId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(GmcpAccount record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(GmcpAccount record) {
        return 0;
    }

    @Override
    public GmcpAccount selectByBuyerId(Integer buyerId) {
        return gmcpAccountMapper.selectByBuyerId(buyerId);
    }

    @Override
    public GmcFundDTO selectMoneyByBuyerId(Integer buyerId) {
        return gmcpAccountMapper.selectMoneyByBuyerId(buyerId);
    }
}
