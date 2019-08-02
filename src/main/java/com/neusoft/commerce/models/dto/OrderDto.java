package com.neusoft.commerce.models.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author zqy
 * @Date 2019/07/23
 */
public class OrderDto {
    //原始订单表
    private Integer stoId;
    private String orderId;
    private String orderCreatedTime; //创建时间
    private String paidTime;
    private String lastModifiedTime; //更新时间
    private String cancelCompleteDate;
    //原始订单明细表
    private Integer solId;
    private String orderItemId;
    private BigDecimal salesPrice;
    private Integer qty;  //数量
    private String skuNo;  //sku
    //销售订单表
    private Integer saoId;
    private BigDecimal productAmount;
    private String orderNo;  //订单编号
    private String orderSts; //订单状态: 1. AwaitingPayment 2. AwaitingShipment 3. SHIPPED 已发货 4. Complete 已完成5. Canceled已取消
    private String refundSts; //退款状态 1. OPEN - 开启 2. CLOSE - 已完结
    private String deliverySts; //发货状态 1. SYNC - 已同步到仓库 2. STOCK_OUT - 已出库 3. SHIPPING - 发货中 4. FULFILLED - 已妥投
    //销售明细表
    private Integer salId;
    private String stsCd;
    private BigDecimal price;
    private String trackingNo;  //物流跟踪号
    //商品表
    private Integer proId;
    private String title;

    //总价格
    private BigDecimal total;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getStoId() {
        return stoId;
    }

    public void setStoId(Integer stoId) {
        this.stoId = stoId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCreatedTime() {
        return orderCreatedTime;
    }

    public void setOrderCreatedTime(String orderCreatedTime) {
        this.orderCreatedTime = orderCreatedTime;
    }

    public String getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
    }

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getCancelCompleteDate() {
        return cancelCompleteDate;
    }

    public void setCancelCompleteDate(String cancelCompleteDate) {
        this.cancelCompleteDate = cancelCompleteDate;
    }

    public Integer getSolId() {
        return solId;
    }

    public void setSolId(Integer solId) {
        this.solId = solId;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    public Integer getSaoId() {
        return saoId;
    }

    public void setSaoId(Integer saoId) {
        this.saoId = saoId;
    }

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderSts() {
        return orderSts;
    }

    public void setOrderSts(String orderSts) {
        this.orderSts = orderSts;
    }

    public String getRefundSts() {
        return refundSts;
    }

    public void setRefundSts(String refundSts) {
        this.refundSts = refundSts;
    }

    public String getDeliverySts() {
        return deliverySts;
    }

    public void setDeliverySts(String deliverySts) {
        this.deliverySts = deliverySts;
    }

    public Integer getSalId() {
        return salId;
    }

    public void setSalId(Integer salId) {
        this.salId = salId;
    }

    public String getStsCd() {
        return stsCd;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
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

    @Override
    public String toString() {
        return "OrderDto{" +
                "stoId=" + stoId +
                ", orderId='" + orderId + '\'' +
                ", orderCreatedTime='" + orderCreatedTime + '\'' +
                ", paidTime='" + paidTime + '\'' +
                ", lastModifiedTime='" + lastModifiedTime + '\'' +
                ", cancelCompleteDate='" + cancelCompleteDate + '\'' +
                ", solId=" + solId +
                ", orderItemId='" + orderItemId + '\'' +
                ", salesPrice=" + salesPrice +
                ", qty=" + qty +
                ", skuNo='" + skuNo + '\'' +
                ", saoId=" + saoId +
                ", productAmount=" + productAmount +
                ", orderNo='" + orderNo + '\'' +
                ", orderSts='" + orderSts + '\'' +
                ", refundSts='" + refundSts + '\'' +
                ", deliverySts='" + deliverySts + '\'' +
                ", salId=" + salId +
                ", stsCd='" + stsCd + '\'' +
                ", price=" + price +
                ", trackingNo='" + trackingNo + '\'' +
                ", proId=" + proId +
                ", title='" + title + '\'' +
                '}';
    }
}
