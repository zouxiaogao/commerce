package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.SaoSalesOrderMapper;
import com.neusoft.commerce.models.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/23
 */
@Service
public class OrderServiceImpl {


    @Autowired
    private SaoSalesOrderMapper salesOrderMapper;

    public List<OrderDto> selectOrderByManId(Integer id,String status){
        return salesOrderMapper.selectOrderByManId(id,status);
    }

}
