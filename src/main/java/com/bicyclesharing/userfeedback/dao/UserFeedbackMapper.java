package com.bicyclesharing.userfeedback.dao;

import com.bicyclesharing.userfeedback.entity.UserFeedback;

import java.util.List;

public interface UserFeedbackMapper {
    int deleteByPrimaryKey(Integer feedbackId);

    int insert(UserFeedback record);

    int insertSelective(UserFeedback record);

    UserFeedback selectByPrimaryKey(Integer feedbackId);

    int updateByPrimaryKeySelective(UserFeedback record);

    int updateByPrimaryKey(UserFeedback record);

    /**
     * 1.添加用户反馈
     * @param userFeedback
     * @return
     */
    boolean insertUserFeedback(UserFeedback userFeedback);

    /**
     * 2.删除用户反馈
     * @param userFeedbackId
     * @return
     */
    boolean deleteUserFeedbackById(Integer userFeedbackId);

    /**
     * 3.修改用户反馈
     * @param userFeedback
     * @return
     */
    boolean updateUserFeedback(UserFeedback userFeedback);

    /**
     * 4.查询用户反馈
     * @param userFeedbackId
     * @return
     */
    UserFeedback selectUserFeedbackById(Integer userFeedbackId);
    List<UserFeedback> selectUserFeedbackByUserId(Integer userId);
    List<UserFeedback> selectUserFeedbackByBicycleId(Integer bicycleId);
    List<UserFeedback> selectAllUserFeedback();
}