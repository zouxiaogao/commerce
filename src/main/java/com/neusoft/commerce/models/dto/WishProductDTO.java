package com.neusoft.commerce.models.dto;

import java.math.BigDecimal;

/**
 * @Author zqy
 * @Date 2019/07/31
 */
public class WishProductDTO {
    private Integer witId;
    private String stsCd;
    private Integer dsrId;
    private Integer proId;
    private String title;
    private String skuCd;
    private Integer ofpId;
    private BigDecimal price;
    private Integer imgId; //图片id
    private String uri; //图片url

    public Integer getWitId() {
        return witId;
    }

    public void setWitId(Integer witId) {
        this.witId = witId;
    }

    public String getStsCd() {
        return stsCd;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public Integer getDsrId() {
        return dsrId;
    }

    public void setDsrId(Integer dsrId) {
        this.dsrId = dsrId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSkuCd() {
        return skuCd;
    }

    public void setSkuCd(String skuCd) {
        this.skuCd = skuCd;
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

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "WishProductDTO{" +
                "witId=" + witId +
                ", stsCd='" + stsCd + '\'' +
                ", dsrId=" + dsrId +
                ", proId=" + proId +
                ", title='" + title + '\'' +
                ", skuCd='" + skuCd + '\'' +
                ", ofpId=" + ofpId +
                ", price=" + price +
                ", imgId=" + imgId +
                ", uri='" + uri + '\'' +
                '}';
    }
}
