package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.WitWishlistMapper;
import com.neusoft.commerce.models.WitWishlist;
import com.neusoft.commerce.models.dto.WishProductDTO;
import com.neusoft.commerce.services.WitWishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/31
 */
@Service
public class WitWishlistServiceImpl implements WitWishlistService {
    @Autowired
    private WitWishlistMapper witWishlistMapper;

    @Override
    public int deleteByPrimaryKey(Integer witId) {
        return 0;
    }

    @Override
    public int insert(WitWishlist record) {
        return 0;
    }

    @Override
    public int insertSelective(WitWishlist record) {
        return witWishlistMapper.insertSelective(record);
    }

    @Override
    public WitWishlist selectByPrimaryKey(Integer witId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(WitWishlist record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(WitWishlist record) {
        return 0;
    }

    @Override
    public WitWishlist selectByProId(Integer proId) {
        return witWishlistMapper.selectByProId(proId);
    }

    @Override
    public int batchRemove(Integer[] id) {
        return witWishlistMapper.batchRemove(id);
    }

    @Override
    public List<WishProductDTO> selectWishList(Integer dsrId) {
        return witWishlistMapper.selectWishList(dsrId);
    }

    @Override
    public int updateByProId(Integer proId) {
        return witWishlistMapper.updateByProId(proId);
    }
}
