package com.neusoft.commerce.models.dto;

/**
 * @Author zqy
 * @Date 2019/07/29
 */

public class BvoInfoDTO {
    private Integer userId;
    private String username;
    private String email;
    private String phone;
    private Integer manbuyerId;
    private Integer dsrId;
    private String name;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getManbuyerId() {
        return manbuyerId;
    }

    public void setManbuyerId(Integer manbuyerId) {
        this.manbuyerId = manbuyerId;
    }

    public Integer getDsrId() {
        return dsrId;
    }

    public void setDsrId(Integer dsrId) {
        this.dsrId = dsrId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BvoInfoDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", manbuyerId=" + manbuyerId +
                ", dsrId=" + dsrId +
                ", name='" + name + '\'' +
                '}';
    }
}
