package com.neusoft.commerce.models.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author zqy
 * @Date 2019/08/02
 */
public class RecordAuditDTO {
    private Integer transactionId;

    private String transactionNumber;

    private String accountName;

    private BigDecimal transactionMoney;

    private Date createTime;

    private Integer transactionAuditId;

    private Byte transactionType;

    private String type;

    private Byte status;
    private String remark;

    public Byte getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Byte transactionType) {
        this.transactionType = transactionType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getTransactionMoney() {
        return transactionMoney;
    }

    public void setTransactionMoney(BigDecimal transactionMoney) {
        this.transactionMoney = transactionMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTransactionAuditId() {
        return transactionAuditId;
    }

    public void setTransactionAuditId(Integer transactionAuditId) {
        this.transactionAuditId = transactionAuditId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
