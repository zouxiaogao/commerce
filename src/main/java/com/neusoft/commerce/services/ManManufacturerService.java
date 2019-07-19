package com.neusoft.commerce.services;

import com.neusoft.commerce.models.ManManufacturer;

/**
 * @Author zqy
 * @Date 2019/07/19
 */

public interface ManManufacturerService {
    int deleteByPrimaryKey(Integer manId);

    int insert(ManManufacturer record);

    int insertSelective(ManManufacturer record);

    ManManufacturer selectByPrimaryKey(Integer manId);

    int updateByPrimaryKeySelective(ManManufacturer record);

    int updateByPrimaryKeyWithBLOBs(ManManufacturer record);

    int updateByPrimaryKey(ManManufacturer record);
}
