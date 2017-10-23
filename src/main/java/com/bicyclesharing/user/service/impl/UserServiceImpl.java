package com.bicyclesharing.user.service.impl;

import com.bicyclesharing.user.dao.UserMapper;
import com.bicyclesharing.user.entity.User;
import com.bicyclesharing.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Tomecs on 2017/10/23.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String username) {
        if ("".equals(username)) {
            return false;
        }
        User user = userMapper.selectUserByName(username);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.selectUserByName(username);
    }

    @Override
    public boolean register(String username) {
        if ("".equals(username)) {
            return false;
        }
        User user = userMapper.selectUserByName(username);
        if (user == null) {
            user = new User(username);
            user.setUserCash(0);
            user.setUserCredit(80);
            user.setUserAccount(new BigDecimal(0.00));
            userMapper.insertUser(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public boolean removeUser(Integer id) {
        if (id <= 0 || "".equals(id)) {
            return false;
        } else {
            userMapper.deleteUser(id);
            return true;
        }
    }

    @Override
    public List<User> getUserByNameLike(String username) {
        return userMapper.selectUserByUserNameLike(username);
    }

    @Override
    public boolean editUser(String userName, BigDecimal userAccount, Integer userCredit, Integer userCash) {
        if ("".equals(userName) || "".equals(userAccount) || "".equals(userCredit) || "".equals(userCash)) {
            return false;
        } else {
            User user = userMapper.selectUserByName(userName);
            if (user == null) {
                return false;
            } else {
                int id = user.getUserId();
                user = new User(id, userName, userAccount, userCredit, userCash);
                userMapper.updateUser(user);
                return true;
            }
        }
    }

    @Override
    public Integer getUserCount() {
        return userMapper.selectUserCount();
    }

    @Override
    public void resetCredit(Integer userId) {
        User user=userMapper.selectUserById(userId);
        user.setUserCredit(80);
        userMapper.updateUser(user);
    }

    @Override
    public void changeCashOne(Integer userId) {
        User user=userMapper.selectUserById(userId);
        user.setUserCash(199);
        userMapper.updateUser(user);
    }

    @Override
    public void changeCashTwo(Integer userId) {
        User user=userMapper.selectUserById(userId);
        user.setUserCash(0);
        userMapper.updateUser(user);
    }

}
