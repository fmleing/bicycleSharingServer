package com.bicyclesharing.bicycle.entity;

import java.util.Date;

public class Bicycle {
    private Integer bicycleId;

    private Double bicycleCurrentX;

    private Double bicycleCurrentY;

    private Date bicycleLastTime;

    private Integer bicycleStatement;

    public Integer getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(Integer bicycleId) {
        this.bicycleId = bicycleId;
    }

    public Double getBicycleCurrentX() {
        return bicycleCurrentX;
    }

    public void setBicycleCurrentX(Double bicycleCurrentX) {
        this.bicycleCurrentX = bicycleCurrentX;
    }

    public Double getBicycleCurrentY() {
        return bicycleCurrentY;
    }

    public void setBicycleCurrentY(Double bicycleCurrentY) {
        this.bicycleCurrentY = bicycleCurrentY;
    }

    public Date getBicycleLastTime() {
        return bicycleLastTime;
    }

    public void setBicycleLastTime(Date bicycleLastTime) {
        this.bicycleLastTime = bicycleLastTime;
    }

    public Integer getBicycleStatement() {
        return bicycleStatement;
    }

    public void setBicycleStatement(Integer bicycleStatement) {
        this.bicycleStatement = bicycleStatement;
    }
}