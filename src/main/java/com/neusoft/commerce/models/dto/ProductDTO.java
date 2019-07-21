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
    private String title;  //商品标题
    private Integer ofpId; //商品价格配置表id
    private BigDecimal price;  //商品价格
    private Integer pckId;  //体积重表id
    private Integer warId; //仓库id
    private Integer pdnId; //商品描述表id
    private String description; //商品描述
    private Integer spaId; //商品属性表id
    private Integer spvId; //商品属性值表id

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getPdnId() {
        return pdnId;
    }

    public void setPdnId(Integer pdnId) {
        this.pdnId = pdnId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", skuId='" + skuCd + '\'' +
                ", manId=" + manId +
                ", title='" + title + '\'' +
                ", ofpId=" + ofpId +
                ", price=" + price +
                ", pckId=" + pckId +
                ", warId=" + warId +
                ", pdnId=" + pdnId +
                ", description='" + description + '\'' +
                ", spaId=" + spaId +
                ", spvId=" + spvId +
                '}';
    }
}
