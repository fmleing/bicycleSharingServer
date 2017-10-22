package com.bicyclesharing.admin.entity;

import java.util.Date;

public class Admin {
    private Integer adminId;

    private String adminName;

    private String adminPassword;

    private String adminEmail;

    private Date adminDate;

    public Date getAdminDate() {
        return adminDate;
    }

    public void setAdminDate(Date adminDate) {
        this.adminDate = adminDate;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail == null ? null : adminEmail.trim();
    }
}