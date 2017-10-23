package com.bicyclesharing.adminmessage.entity;

import java.util.Date;

public class AdminMessage {
    private Integer adminMessageId;

    private String adminMessageTitle;

    private Date adminMessageTime;

    private Integer adminId;

    private String adminMessageContent;

    public AdminMessage(String adminMessageTitle, Date adminMessageTime, Integer adminId, String adminMessageContent) {
        this.adminMessageTitle = adminMessageTitle;
        this.adminMessageTime = adminMessageTime;
        this.adminId = adminId;
        this.adminMessageContent = adminMessageContent;
    }

    public Integer getAdminMessageId() {
        return adminMessageId;
    }

    public void setAdminMessageId(Integer adminMessageId) {
        this.adminMessageId = adminMessageId;
    }

    public String getAdminMessageTitle() {
        return adminMessageTitle;
    }

    public void setAdminMessageTitle(String adminMessageTitle) {
        this.adminMessageTitle = adminMessageTitle == null ? null : adminMessageTitle.trim();
    }

    public Date getAdminMessageTime() {
        return adminMessageTime;
    }

    public void setAdminMessageTime(Date adminMessageTime) {
        this.adminMessageTime = adminMessageTime;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminMessageContent() {
        return adminMessageContent;
    }

    public void setAdminMessageContent(String adminMessageContent) {
        this.adminMessageContent = adminMessageContent == null ? null : adminMessageContent.trim();
    }
}