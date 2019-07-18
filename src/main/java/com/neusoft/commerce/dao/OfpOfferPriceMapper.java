package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.OfpOfferPrice;

public interface OfpOfferPriceMapper {
    int deleteByPrimaryKey(Integer ofpId);

    int insert(OfpOfferPrice record);

    int insertSelective(OfpOfferPrice record);

    OfpOfferPrice selectByPrimaryKey(Integer ofpId);

    int updateByPrimaryKeySelective(OfpOfferPrice record);

    int updateByPrimaryKey(OfpOfferPrice record);
}