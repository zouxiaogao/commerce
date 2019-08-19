package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.StoStoreOrderMapper;
import com.neusoft.commerce.models.StoStoreOrder;
import com.neusoft.commerce.services.StoStoreOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zqy
 * @Date 2019/08/02
 */
@Service
public class StoStoreOrderServiceImpl implements StoStoreOrderService {
    @Autowired
    private StoStoreOrderMapper storeOrderMapper;

    @Override
    public int deleteByPrimaryKey(Integer stoId) {
        return 0;
    }

    @Override
    public int insert(StoStoreOrder record) {
        return storeOrderMapper.insert(record);
    }

    @Override
    public int insertSelective(StoStoreOrder record) {
        return 0;
    }

    @Override
    public StoStoreOrder selectByPrimaryKey(Integer stoId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(StoStoreOrder record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(StoStoreOrder record) {
        return 0;
    }

    @Override
    public List<StoStoreOrder> selectStoreOrderList(List<Integer> ids) {
        return storeOrderMapper.selectStoreOrderList(ids);
    }
}
