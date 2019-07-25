package com.neusoft.commerce.models.dto;

import java.math.BigDecimal;

/**
 * @Author zqy
 * @Date 2019/07/21
 */

//商品详细信息
public class ProductDTO {

    private Integer proId;  //商品id
    private String skuCd;  //sku编码
    private Integer manId; //品牌商id
    private String upc;  //upc码
    private String ena;  //ean码
    private String model;  //型号
    private String title;  //商品标题
    private String timeUnit;  //保修期
    private Integer ofpId; //商品价格配置表id
    private BigDecimal price;  //商品价格
    private Integer pckId;  //体积重表id
    private Integer warId; //仓库id
    private BigDecimal height;  //高
    private BigDecimal width;  //宽
    private BigDecimal length;  //长
    private BigDecimal weight;  //重量
    private Integer pdnId; //商品描述表id
    private String typeCd; //Amazon商品描述
    private String descrition; //商品描述  数据库字段DESCRITION
    private Integer spaId; //商品属性表id
    private Integer spvId; //商品属性值表id
    private String isDel; //删除标记

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getSkuCd() {
        return skuCd;
    }

    public void setSkuCd(String skuCd) {
        this.skuCd = skuCd;
    }

    public Integer getManId() {
        return manId;
    }

    public void setManId(Integer manId) {
        this.manId = manId;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getEna() {
        return ena;
    }

    public void setEna(String ena) {
        this.ena = ena;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public Integer getOfpId() {
        return ofpId;
    }

    public void setOfpId(Integer ofpId) {
        this.ofpId = ofpId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPckId() {
        return pckId;
    }

    public void setPckId(Integer pckId) {
        this.pckId = pckId;
    }

    public Integer getWarId() {
        return warId;
    }

    public void setWarId(Integer warId) {
        this.warId = warId;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getPdnId() {
        return pdnId;
    }

    public void setPdnId(Integer pdnId) {
        this.pdnId = pdnId;
    }

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public Integer getSpaId() {
        return spaId;
    }

    public void setSpaId(Integer spaId) {
        this.spaId = spaId;
    }

    public Integer getSpvId() {
        return spvId;
    }

    public void setSpvId(Integer spvId) {
        this.spvId = spvId;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "proId=" + proId +
                ", skuCd='" + skuCd + '\'' +
                ", manId=" + manId +
                ", upc='" + upc + '\'' +
                ", ena='" + ena + '\'' +
                ", model='" + model + '\'' +
                ", title='" + title + '\'' +
                ", timeUnit='" + timeUnit + '\'' +
                ", ofpId=" + ofpId +
                ", price=" + price +
                ", pckId=" + pckId +
                ", warId=" + warId +
                ", height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", weight=" + weight +
                ", pdnId=" + pdnId +
                ", typeCd='" + typeCd + '\'' +
                ", descrition='" + descrition + '\'' +
                ", spaId=" + spaId +
                ", spvId=" + spvId +
                ", isDel='" + isDel + '\'' +
                '}';
    }
}
