package com.bicyclesharing.userfeedback.service.impl;

import com.bicyclesharing.userfeedback.dao.UserFeedbackMapper;
import com.bicyclesharing.userfeedback.entity.UserFeedback;
import com.bicyclesharing.userfeedback.service.UserFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomecs on 2017/10/23.
 */
@Service
public class UserFeedbackServiceImpl implements UserFeedbackService{

    @Autowired
    private UserFeedbackMapper userFeedbackMapper;

    @Override
    public boolean addFeedback(UserFeedback userFeedback) {
        userFeedbackMapper.insertUserFeedback(userFeedback);
        return true;
    }

    @Override
    public UserFeedback getFeedback(Integer feedbackId) {
        return userFeedbackMapper.selectUserFeedbackById(feedbackId);
    }

    @Override
    public List<UserFeedback> getFeedbackByBicycleId(Integer bicycleId) {
        return userFeedbackMapper.selectUserFeedbackByUserId(1);
    }

    @Override
    public List<UserFeedback> getFeedbackByUserId(Integer userId) {
        return userFeedbackMapper.selectUserFeedbackByBicycleId(1);
    }

    @Override
    public List<UserFeedback> getAllFeedback() {
        return userFeedbackMapper.selectAllUserFeedback();
    }

    @Override
    public boolean resolved(Integer feedbackId) {
        if (feedbackId == null) {
            return false;
        } else {
            UserFeedback userFeedback = userFeedbackMapper.selectUserFeedbackById(feedbackId);
            userFeedback.setFeedbackStatement(1);
            userFeedbackMapper.updateUserFeedback(userFeedback);
            return true;
        }
    }

    @Override
    public boolean removeFeedback(Integer feedbackId) {
        if (feedbackId <= 0 || "".equals(feedbackId)) {
            return false;
        } else {
            userFeedbackMapper.deleteUserFeedbackById(feedbackId);
            return true;
        }
    }

}
