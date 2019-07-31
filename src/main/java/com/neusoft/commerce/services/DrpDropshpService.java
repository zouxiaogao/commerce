package com.neusoft.commerce.services;

import com.neusoft.commerce.models.DrpDropshipPrice;

/**
 * @Author zqy
 * @Date 2019/07/31
 */
public interface DrpDropshpService {
    int deleteByPrimaryKey(Integer drpId);

    int insert(DrpDropshipPrice record);

    int insertSelective(DrpDropshipPrice record);

    DrpDropshipPrice selectByPrimaryKey(Integer drpId);

    int updateByPrimaryKeySelective(DrpDropshipPrice record);

    int updateByPrimaryKey(DrpDropshipPrice record);
}
