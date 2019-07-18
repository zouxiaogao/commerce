package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.ShaShippingAddress;

public interface ShaShippingAddressMapper {
    int insert(ShaShippingAddress record);

    int insertSelective(ShaShippingAddress record);
}