package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.DrpDropshipPriceMapper;
import com.neusoft.commerce.models.DrpDropshipPrice;
import com.neusoft.commerce.services.DrpDropshpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zqy
 * @Date 2019/07/31
 */
@Service
public class DrpDropshpServiceImpl implements DrpDropshpService {

    @Autowired
    private DrpDropshipPriceMapper dropshipPriceMapper;
    @Override
    public int deleteByPrimaryKey(Integer drpId) {
        return 0;
    }

    @Override
    public int insert(DrpDropshipPrice record) {
        return 0;
    }

    @Override
    public int insertSelective(DrpDropshipPrice record) {
        return dropshipPriceMapper.insertSelective(record);
    }

    @Override
    public DrpDropshipPrice selectByPrimaryKey(Integer drpId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(DrpDropshipPrice record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(DrpDropshipPrice record) {
        return 0;
    }
}
