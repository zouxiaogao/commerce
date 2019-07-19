package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.ManManufacturerMapper;
import com.neusoft.commerce.models.ManManufacturer;
import com.neusoft.commerce.services.ManManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zqy
 * @Date 2019/07/19
 */
@Service
public class ManManufacturerServiceImpl implements ManManufacturerService {


    @Autowired
    private ManManufacturerMapper manManufacturerMapper;

    @Override
    public int deleteByPrimaryKey(Integer manId) {
        return 0;
    }

    @Override
    public int insert(ManManufacturer record) {
        return manManufacturerMapper.insert(record);
    }

    @Override
    public int insertSelective(ManManufacturer record) {
        return 0;
    }

    @Override
    public ManManufacturer selectByPrimaryKey(Integer manId) {
        return manManufacturerMapper.selectByPrimaryKey(manId);
    }

    @Override
    public int updateByPrimaryKeySelective(ManManufacturer record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(ManManufacturer record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ManManufacturer record) {
        return manManufacturerMapper.updateByPrimaryKey(record);
    }
}
