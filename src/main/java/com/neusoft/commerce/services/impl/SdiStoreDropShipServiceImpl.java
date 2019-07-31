package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.SdiStoreDropshipItemMapper;
import com.neusoft.commerce.models.SdiStoreDropshipItem;
import com.neusoft.commerce.services.SdiStoreDropShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zqy
 * @Date 2019/07/31
 */
@Service
public class SdiStoreDropShipServiceImpl implements SdiStoreDropShipService {

    @Autowired
    private SdiStoreDropshipItemMapper storeDropshipItemMapper;

    @Override
    public int deleteByPrimaryKey(Integer dilId) {
        return 0;
    }

    @Override
    public int insert(SdiStoreDropshipItem record) {
        return 0;
    }

    @Override
    public int insertSelective(SdiStoreDropshipItem record) {
        return storeDropshipItemMapper.insertSelective(record);
    }

    @Override
    public SdiStoreDropshipItem selectByPrimaryKey(Integer dilId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(SdiStoreDropshipItem record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SdiStoreDropshipItem record) {
        return 0;
    }
}
