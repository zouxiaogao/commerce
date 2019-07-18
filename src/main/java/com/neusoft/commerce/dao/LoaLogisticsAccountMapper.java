package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.LoaLogisticsAccount;

public interface LoaLogisticsAccountMapper {
    int insert(LoaLogisticsAccount record);

    int insertSelective(LoaLogisticsAccount record);
}