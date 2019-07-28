package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.*;
import com.neusoft.commerce.models.*;
import com.neusoft.commerce.models.dto.ProductCategory;
import com.neusoft.commerce.models.dto.ProductDTO;
import com.neusoft.commerce.models.dto.ProductUtils;
import com.neusoft.commerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/21
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProProductMapper proProductMapper;
    @Autowired
    private PckPackageInfoMapper pckPackageInfoMapper;
    @Autowired
    private OfpOfferPriceMapper offerPriceMapper;
    @Autowired
    private PdnProductDescritionMapper productDescritionMapper;
    @Autowired
    private PrcProductCategoryMapper productCategoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer proId) {
        return proProductMapper.deleteByPrimaryKey(proId);
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
        return proProductMapper.selectByPrimaryKey(proId);
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
        return proProductMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ProductDTO> selectByManId(Integer manId) {
        return proProductMapper.selectByManId(manId);
    }

    @Override
    public List<ProductDTO> selectAllByManId(Integer manId) {
        return proProductMapper.selectAllByManId(manId);
    }

    @Override
    public List<ProductDTO> selectByManIdAndCondition(Integer manBuyerId,String tittle) {
        return proProductMapper.selectByManIdAndCondition(manBuyerId,tittle);
    }

    @Override
    public ProductDTO selectByProId(Integer proId) {
        return proProductMapper.selectByProId(proId);
    }


    //修改
    @Override
    @Transactional
    public int updateProduct(ProductDTO productDTO,String name) {
        //插入product表
        ProProduct product = ProductUtils.setProduct(productDTO);
        product.setLastUpdateBy(name);
        product.setManId(productDTO.getManId());
        proProductMapper.updateByPrimaryKey(product);

        //插入pck
        PckPackageInfo packageInfo = ProductUtils.setPackage(productDTO);
        packageInfo.setLastUpdateBy(name);
        packageInfo.setProId(product.getProId());
        if(packageInfo.getPckId()!=null){
            pckPackageInfoMapper.updateByPrimaryKey(packageInfo);
        }else {
            pckPackageInfoMapper.insert(packageInfo);
        }


        //插入ofp
        OfpOfferPrice offerPrice = ProductUtils.setOfp(productDTO);
        offerPrice.setLastUpdateBy(name);
        offerPrice.setProId(product.getProId());
        offerPrice.setManId(productDTO.getManId());
        if(offerPrice.getOfpId()!=null){
            offerPriceMapper.updateByPrimaryKey(offerPrice);
        }else {
            offerPriceMapper.insert(offerPrice);
        }


        //插入pdn
        PdnProductDescrition productDescrition = ProductUtils.setPdn(productDTO);
        productDescrition.setLastUpdateBy(name);
        productDescrition.setProId(productDTO.getProId());
        if(productDescrition.getPdnId()!=null){
            productDescritionMapper.updateByPrimaryKey(productDescrition);
        }else {
            productDescritionMapper.insert(productDescrition);
        }

        return 1;
    }

    @Override
    @Transactional
    public int insertProduct(ProductDTO productDTO, String name) {
        //插入product表
        ProProduct product = ProductUtils.setProduct(productDTO);
        product.setCreatedBy(name);
        product.setManId(productDTO.getManId());
        proProductMapper.insert(product);

        //插入pck
        PckPackageInfo packageInfo = ProductUtils.setPackage(productDTO);
        packageInfo.setCreatedBy(name);
        packageInfo.setProId(product.getProId());
        pckPackageInfoMapper.insert(packageInfo);

        //插入ofp
        OfpOfferPrice offerPrice = ProductUtils.setOfp(productDTO);
        offerPrice.setCreatedBy(name);
        offerPrice.setManId(productDTO.getManId());
        offerPrice.setProId(product.getProId());
        offerPriceMapper.insert(offerPrice);

        //插入pdn
        PdnProductDescrition productDescrition = ProductUtils.setPdn(productDTO);
        productDescrition.setCreatedBy(name);
        productDescrition.setProId(product.getProId());
        productDescritionMapper.insert(productDescrition);

        return 0;
    }

    @Override
    public int deleteByProduct(Integer id) {

        int i = proProductMapper.deleteProductById(id);

        return 0;
    }

    @Override
    public List<ProductCategory> selectProductCategory(Integer manId) {
        return proProductMapper.selectProductCategory(manId);
    }

    @Override
    public ProductCategory selectProductCategoryDetail(Integer proId) {
        return proProductMapper.selectProductCategoryDetail(proId);
    }


    public PrcProductCategory selectCategory(Integer id){
        return productCategoryMapper.selectByProId(id);
    }



    public int updateProductCategory(ProductCategory category){

        PrcProductCategory prcProductCategory=new PrcProductCategory();
        prcProductCategory.setPrcId(category.getPrcId());
        prcProductCategory.setProId(category.getProId());
        prcProductCategory.setCategoryName(category.getCategoryName());

        return productCategoryMapper.updateByPrimaryKey(prcProductCategory);
    }

    public int insertProductCategory(ProductCategory category){

        PrcProductCategory prcProductCategory=new PrcProductCategory();
        prcProductCategory.setProId(category.getProId());
        prcProductCategory.setCategoryName(category.getCategoryName());
        return productCategoryMapper.insert(prcProductCategory);
    }

}
