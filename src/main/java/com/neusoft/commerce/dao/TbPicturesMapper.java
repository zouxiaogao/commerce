package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.TbPictures;

public interface TbPicturesMapper {
    int deleteByPrimaryKey(String picturesId);

    int insert(TbPictures record);

    int insertSelective(TbPictures record);

    TbPictures selectByPrimaryKey(String picturesId);

    int updateByPrimaryKeySelective(TbPictures record);

    int updateByPrimaryKey(TbPictures record);
}