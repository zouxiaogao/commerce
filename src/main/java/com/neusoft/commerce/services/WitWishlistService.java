package com.neusoft.commerce.services;

import com.neusoft.commerce.models.WitWishlist;
import com.neusoft.commerce.models.dto.WishProductDTO;

import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/31
 */
public interface WitWishlistService {
    int deleteByPrimaryKey(Integer witId);

    int insert(WitWishlist record);

    int insertSelective(WitWishlist record);

    WitWishlist selectByPrimaryKey(Integer witId);

    int updateByPrimaryKeySelective(WitWishlist record);

    int updateByPrimaryKey(WitWishlist record);

    WitWishlist selectByProId(Integer proId);
    int batchRemove(Integer[] id);
    List<WishProductDTO> selectWishList(Integer dsrId);
    int updateByProId(Integer proId);


}
