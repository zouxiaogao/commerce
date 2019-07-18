package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.WitWishlist;

public interface WitWishlistMapper {
    int deleteByPrimaryKey(Integer witId);

    int insert(WitWishlist record);

    int insertSelective(WitWishlist record);

    WitWishlist selectByPrimaryKey(Integer witId);

    int updateByPrimaryKeySelective(WitWishlist record);

    int updateByPrimaryKey(WitWishlist record);
}