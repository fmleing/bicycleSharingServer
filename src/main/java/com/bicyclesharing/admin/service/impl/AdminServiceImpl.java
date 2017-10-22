package com.bicyclesharing.admin.service.impl;

import com.bicyclesharing.admin.dao.AdminMapper;
import com.bicyclesharing.admin.entity.Admin;
import com.bicyclesharing.admin.service.AdminService;
import com.bicyclesharing.util.EncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tomecs on 2017/10/21.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int login(String adminName, String adminPassword) {
        //根据输入的用户名查询管理员实例,然后分情况讨论,最后返回1表示可登陆
        Admin admin = adminMapper.selectAdminByName(adminName);
        if (admin == null) {
            return 0;
        } else {
            String passwordMD5 = EncoderUtil.EncoderByMd5(adminPassword);
            if (!admin.getAdminPassword().equals(passwordMD5)) {
                return 0;
            }
            return 1;
        }
    }
}
