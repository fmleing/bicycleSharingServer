package com.bicyclesharing.userfeedback.dao;

import com.bicyclesharing.userfeedback.entity.UserFeedback;

public interface UserFeedbackMapper {
    int deleteByPrimaryKey(Integer feedbackId);

    int insert(UserFeedback record);

    int insertSelective(UserFeedback record);

    UserFeedback selectByPrimaryKey(Integer feedbackId);

    int updateByPrimaryKeySelective(UserFeedback record);

    int updateByPrimaryKey(UserFeedback record);
}