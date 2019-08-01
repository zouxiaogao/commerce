package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.WitWishlist;
import com.neusoft.commerce.models.dto.WishProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WitWishlistMapper {
    int deleteByPrimaryKey(Integer witId);

    int insert(WitWishlist record);

    int insertSelective(WitWishlist record);

    WitWishlist selectByPrimaryKey(Integer witId);

    int updateByPrimaryKeySelective(WitWishlist record);

    int updateByPrimaryKey(WitWishlist record);

    int updateByProId(Integer proId);




    WitWishlist selectByProId(Integer proId);

    int batchRemove(@Param("ids") Integer[] id);

    List<WishProductDTO> selectWishList(Integer dsrId);
}