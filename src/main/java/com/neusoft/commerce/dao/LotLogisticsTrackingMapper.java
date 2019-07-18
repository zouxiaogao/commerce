package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.LotLogisticsTracking;

public interface LotLogisticsTrackingMapper {
    int insert(LotLogisticsTracking record);

    int insertSelective(LotLogisticsTracking record);
}