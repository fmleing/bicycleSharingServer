package com.bicyclesharing.userfeedback.entity;

import java.util.Date;

public class UserFeedback {
    private Integer feedbackId;

    private String feedbackTitle;

    private String feedbackContent;

    private Integer userId;

    private Integer bicycleId;

    private Date feedbackTime;

    private Integer feedbackStatement;

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public UserFeedback(String feedbackTitle, String feedbackContent, Integer userId, Integer bicycleId, Date feedbackTime, Integer feedbackStatement) {
        this.feedbackTitle = feedbackTitle;
        this.feedbackContent = feedbackContent;
        this.userId = userId;
        this.bicycleId = bicycleId;
        this.feedbackTime = feedbackTime;
        this.feedbackStatement = feedbackStatement;
    }

    public String getFeedbackTitle() {
        return feedbackTitle;
    }

    public void setFeedbackTitle(String feedbackTitle) {
        this.feedbackTitle = feedbackTitle == null ? null : feedbackTitle.trim();
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent == null ? null : feedbackContent.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(Integer bicycleId) {
        this.bicycleId = bicycleId;
    }

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public Integer getFeedbackStatement() {
        return feedbackStatement;
    }

    public void setFeedbackStatement(Integer feedbackStatement) {
        this.feedbackStatement = feedbackStatement;
    }
}