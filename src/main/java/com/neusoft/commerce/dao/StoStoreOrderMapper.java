package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.StoStoreOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoStoreOrderMapper {
    int deleteByPrimaryKey(Integer stoId);

    int insert(StoStoreOrder record);

    int insertSelective(StoStoreOrder record);

    StoStoreOrder selectByPrimaryKey(Integer stoId);

    int updateByPrimaryKeySelective(StoStoreOrder record);

    int updateByPrimaryKey(StoStoreOrder record);

    List<StoStoreOrder> selectStoreOrderList(@Param("list") List<Integer> ids);
}