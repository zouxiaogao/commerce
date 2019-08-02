package com.neusoft.commerce.dao;


import com.neusoft.commerce.models.SaoSalesOrder;
import com.neusoft.commerce.models.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SaoSalesOrderMapper {
    int deleteByPrimaryKey(Integer saoId);

    int insert(SaoSalesOrder record);

    int insertSelective(SaoSalesOrder record);

    SaoSalesOrder selectByPrimaryKey(Integer saoId);

    int updateByPrimaryKeySelective(SaoSalesOrder record);

    int updateByPrimaryKeyWithBLOBs(SaoSalesOrder record);

    int updateByPrimaryKey(SaoSalesOrder record);
    int updateBySaoId(@Param("saoId") Integer saoId,@Param("status")String status);


    List<OrderDto> selectOrderByManId(@Param("id") Integer id,@Param("status")String status);

    public List<OrderDto> selectSaoOrderByStos(@Param("list") List<Integer> ids,@Param("status") String status);

    OrderDto selectOrderDetailBySaoId(Integer saoId);
}