package com.neusoft.commerce.models.dto;

import com.neusoft.commerce.models.OfpOfferPrice;
import com.neusoft.commerce.models.PckPackageInfo;
import com.neusoft.commerce.models.PdnProductDescrition;
import com.neusoft.commerce.models.ProProduct;

/**
 * @Author zqy
 * @Date 2019/07/22
 */

//组装数据
public class ProductUtils {


    //商品表
    public  static ProProduct setProduct(ProductDTO productDTO){
        ProProduct product=new ProProduct();
        product.setProId(productDTO.getProId());
        product.setModel(productDTO.getModel());
        product.setSkuCd(productDTO.getSkuCd());
        product.setUpc(productDTO.getUpc());
        product.setEan(productDTO.getEna());
        product.setTitle(productDTO.getTitle());
        product.setTimeUnit(productDTO.getTimeUnit());

        return product;
    }

    //体积重表
    public static PckPackageInfo setPackage(ProductDTO productDTO){
        PckPackageInfo packageInfo=new PckPackageInfo();
        packageInfo.setPckId(productDTO.getPckId());
        packageInfo.setProId(productDTO.getProId());
        packageInfo.setWarId(1);
        packageInfo.setLength(productDTO.getLength());
        packageInfo.setWeight(productDTO.getWeight());
        packageInfo.setWidth(productDTO.getWidth());
        packageInfo.setHeight(productDTO.getHeight());

        return packageInfo;
    }


    //ofp表
    public static OfpOfferPrice setOfp(ProductDTO productDTO){
        OfpOfferPrice offerPrice=new OfpOfferPrice();
        offerPrice.setOfpId(productDTO.getOfpId());
        offerPrice.setProId(productDTO.getProId());
        offerPrice.setPrice(productDTO.getPrice());

        return offerPrice;
    }

    //pdn表
    public static PdnProductDescrition setPdn(ProductDTO productDTO){
        PdnProductDescrition productDescrition=new PdnProductDescrition();
        productDescrition.setPdnId(productDTO.getPdnId());
        productDescrition.setProId(productDTO.getProId());
        productDescrition.setTypeCd(productDTO.getTypeCd());
        productDescrition.setDescrition(productDTO.getDescription());
        return  productDescrition;
    }



}
