package com.neusoft.commerce.models.dto;

/**
 * @Author zqy
 * @Date 2019/07/27
 */
public class ProductCategory {
    private Integer proId;  //商品id
    private String stsCd;  //sku编码
    private Integer manId; //品牌商id
    private String title;  //商品标题

    private Integer prcId;
    private String categoryName;


    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getStsCd() {
        return stsCd;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
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

    public Integer getPrcId() {
        return prcId;
    }

    public void setPrcId(Integer prcId) {
        this.prcId = prcId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "proId=" + proId +
                ", stsCd='" + stsCd + '\'' +
                ", manId=" + manId +
                ", title='" + title + '\'' +
                ", prcId=" + prcId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
