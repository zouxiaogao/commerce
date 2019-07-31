package com.neusoft.commerce.models.dto;

/**
 * @Author zqy
 * @Date 2019/07/30
 */
public class DsrStoreDTO {
    private Integer dsrId;

    private Integer strId;

    private String storeName;

    private String stsCd;

    public Integer getDsrId() {
        return dsrId;
    }

    public void setDsrId(Integer dsrId) {
        this.dsrId = dsrId;
    }

    public Integer getStrId() {
        return strId;
    }

    public void setStrId(Integer strId) {
        this.strId = strId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStsCd() {
        return stsCd;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    @Override
    public String toString() {
        return "DsrStoreDTO{" +
                "dsrId=" + dsrId +
                ", strId=" + strId +
                ", storeName='" + storeName + '\'' +
                ", stsCd='" + stsCd + '\'' +
                '}';
    }
}
