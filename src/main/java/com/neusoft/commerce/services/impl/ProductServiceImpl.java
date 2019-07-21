package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.ProProductMapper;
import com.neusoft.commerce.models.ProProduct;
import com.neusoft.commerce.models.dto.ProductDTO;
import com.neusoft.commerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/21
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProProductMapper proProductMapper;

    @Override
    public int deleteByPrimaryKey(Integer proId) {
        return 0;
    }

    @Override
    public int insert(ProProduct record) {
        return 0;
    }

    @Override
    public int insertSelective(ProProduct record) {
        return 0;
    }

    @Override
    public ProProduct selectByPrimaryKey(Integer proId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(ProProduct record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(ProProduct record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ProProduct record) {
        return 0;
    }

    @Override
    public List<ProductDTO> selectByManId(Integer manId) {
        return proProductMapper.selectByManId(manId);
    }

    @Override
    public List<ProductDTO> selectByManIdAndCondition(Integer manBuyerId,String tittle) {
        return proProductMapper.selectByManIdAndCondition(manBuyerId,tittle);
    }
}
