package com.bicyclesharing.user.entity;

import java.math.BigDecimal;

public class User {
    private Integer userId;

    private String userName;

    private BigDecimal userAccount;

    private Integer userCredit;

    private Integer userCash;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(Integer userId, String userName, BigDecimal userAccount, Integer userCredit, Integer userCash) {
        this.userId = userId;
        this.userName = userName;
        this.userAccount = userAccount;
        this.userCredit = userCredit;
        this.userCash = userCash;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public BigDecimal getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(BigDecimal userAccount) {
        this.userAccount = userAccount;
    }

    public Integer getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(Integer userCredit) {
        this.userCredit = userCredit;
    }

    public Integer getUserCash() {
        return userCash;
    }

    public void setUserCash(Integer userCash) {
        this.userCash = userCash;
    }
}