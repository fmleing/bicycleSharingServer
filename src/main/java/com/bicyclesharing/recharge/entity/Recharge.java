package com.bicyclesharing.recharge.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Recharge {
    private Integer rechargeId;

    private Integer userId;

    private BigDecimal rechargeAmount;

    private BigDecimal remaining;

    private Date rechargeTime;

    public Recharge() {
    }

    public Recharge(Integer userId, BigDecimal rechargeAmount, BigDecimal remaining, Date rechargeTime) {
        this.userId = userId;
        this.rechargeAmount = rechargeAmount;
        this.remaining = remaining;
        this.rechargeTime = rechargeTime;
    }

    public Integer getRechargeId() {
        return rechargeId;
    }

    public void setRechargeId(Integer rechargeId) {
        this.rechargeId = rechargeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public BigDecimal getRemaining() {
        return remaining;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }

    public Date getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(Date rechargeTime) {
        this.rechargeTime = rechargeTime;
    }
}