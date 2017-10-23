package com.bicyclesharing.borrow.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Borrow {
    private Integer borrowId;

    private Integer bicycleId;

    private Integer userId;

    private Date borrowStartTime;

    private Date borrowEndTime;

    private Double borrowStartX;

    private Double borrowStartY;

    private Double borrowEndX;

    private Double borrowEndY;

    private BigDecimal cost;

    private BigDecimal remaining;

    public Borrow() {
    }

    public Borrow(Integer borrowId, Integer bicycleId, Date borrowStartTime, Date borrowEndTime, Double borrowStartX, Double borrowStartY, Double borrowEndX, Double borrowEndY, BigDecimal cost, BigDecimal remaining) {
        this.borrowId = borrowId;
        this.bicycleId = bicycleId;
        this.borrowStartTime = borrowStartTime;
        this.borrowEndTime = borrowEndTime;
        this.borrowStartX = borrowStartX;
        this.borrowStartY = borrowStartY;
        this.borrowEndX = borrowEndX;
        this.borrowEndY = borrowEndY;
        this.cost = cost;
        this.remaining = remaining;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Integer getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(Integer bicycleId) {
        this.bicycleId = bicycleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getBorrowStartTime() {
        return borrowStartTime;
    }

    public void setBorrowStartTime(Date borrowStartTime) {
        this.borrowStartTime = borrowStartTime;
    }

    public Date getBorrowEndTime() {
        return borrowEndTime;
    }

    public void setBorrowEndTime(Date borrowEndTime) {
        this.borrowEndTime = borrowEndTime;
    }

    public Double getBorrowStartX() {
        return borrowStartX;
    }

    public void setBorrowStartX(Double borrowStartX) {
        this.borrowStartX = borrowStartX;
    }

    public Double getBorrowStartY() {
        return borrowStartY;
    }

    public void setBorrowStartY(Double borrowStartY) {
        this.borrowStartY = borrowStartY;
    }

    public Double getBorrowEndX() {
        return borrowEndX;
    }

    public void setBorrowEndX(Double borrowEndX) {
        this.borrowEndX = borrowEndX;
    }

    public Double getBorrowEndY() {
        return borrowEndY;
    }

    public void setBorrowEndY(Double borrowEndY) {
        this.borrowEndY = borrowEndY;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getRemaining() {
        return remaining;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }
}