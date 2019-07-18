package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.ImgImage;

public interface ImgImageMapper {
    int deleteByPrimaryKey(Integer imgId);

    int insert(ImgImage record);

    int insertSelective(ImgImage record);

    ImgImage selectByPrimaryKey(Integer imgId);

    int updateByPrimaryKeySelective(ImgImage record);

    int updateByPrimaryKey(ImgImage record);
}