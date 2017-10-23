package com.bicyclesharing.admin.service.impl;

import com.bicyclesharing.admin.dao.AdminMapper;
import com.bicyclesharing.admin.entity.Admin;
import com.bicyclesharing.admin.service.AdminService;
import com.bicyclesharing.adminmessage.dao.AdminMessageMapper;
import com.bicyclesharing.adminmessage.entity.AdminMessage;
import com.bicyclesharing.util.EncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Tomecs on 2017/10/21.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminMessageMapper adminMessageMapper;

    /*使用注解控制事务(异常回滚)优点有三:
        1.开发团队达成一致约定,可以明确标注事务方法的编程风格
        2.编码时对待事务如同对待循环,里面的执行时间尽可能的少
        3.过于简单的比如一条修改,查询操作不需要事务控制
        这里偷个懒直接放外面,因为我也不是很懂具体哪个方法要加.*/
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

    @Override
    public boolean addAdmin(String adminName, String adminPassword1, String adminPassword2, String adminEmail) {
        //在窗口我们输入管理员名+密码+两次密码+邮箱,具体逻辑可以画二叉树清楚点
        if ("".equals(adminName) || "".equals(adminPassword1) || "".equals(adminPassword2) || "".equals(adminEmail)) {
            return false;
        } else {
            if (!adminPassword1.equals(adminPassword2)) {
                return false;
            } else {
                if (adminMapper.selectAdminByName(adminName) != null) {
                    //已经有这个管理员了
                    return false;
                }
                //下面就可以插入了
                Admin admin = new Admin(adminName, EncoderUtil.EncoderByMd5(adminPassword1), adminEmail);
                adminMapper.insertAdmin(admin);
                return true;
            }
        }
    }

    @Override
    public boolean removeAdmin(Integer adminId) {
        //根据输入的Id移除,慎用
        if (adminId <= 0 || adminId == null) {
            return false;
        } else {
            //这里其实不严谨,但是我不用删除这个操作,所以不需要多写
            adminMapper.deleteAdmin(adminId);
            return true;
        }
    }

    @Override
    public Admin getAdminById(Integer adminId) {
        return adminMapper.selectAdminById(adminId);
    }

    @Override
    public Admin getAdminByName(String adminName) {
        return adminMapper.selectAdminByName(adminName);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminMapper.selectAllAdmin();
    }

    @Override
    public List<Admin> getAdminByNameLike(String name) {
        return adminMapper.selectAdminByNameLike(name);
    }

    @Override
    public boolean editAdmin(Integer adminId, String adminName, String adminPassword, String adminEmail) {
        if (adminId == null || "".equals(adminName) || "".equals(adminPassword) || "".equals(adminEmail)) {
            return false;
        } else {
            Admin admin = adminMapper.selectAdminById(adminId);
            /**
             * 必须修改密码,否则你不改的话,密码其实本身也是被修改了的,被再次MD5加密了
             */
            if (adminPassword.equals(admin.getAdminPassword())) {
                return false;
            }
            admin.setAdminName(adminName);
            admin.setAdminPassword(EncoderUtil.EncoderByMd5(adminPassword));
            admin.setAdminEmail(adminEmail);
            adminMapper.updateAdmin(admin);
            return true;
        }
    }

   /*---------------------------------------------------------------------------------*/

    @Override
    public boolean addAdminMessage(String adminMessageTitle, String adminMessageContent, Integer adminId) {
        if ("".equals(adminMessageTitle) || "".equals(adminMessageContent) || "".equals(adminId) || adminMapper.selectAdminById(adminId) == null) {
            return false;
        } else {
            AdminMessage adminMessage = new AdminMessage(adminMessageTitle,  new Date(), adminId,adminMessageContent);
            adminMessageMapper.insertAdminMessage(adminMessage);
            return true;
        }
    }

    @Override
    public boolean editAdminMessage(Integer adminMessageId, String adminMessageTitle, String adminMessageContent) {
        AdminMessage adminMessage = adminMessageMapper.getAdminMessage(adminMessageId);
        if ("".equals(adminMessageTitle) || "".equals(adminMessageContent)) {
            return false;
        }
        adminMessage.setAdminMessageTitle(adminMessageTitle);
        adminMessage.setAdminMessageContent(adminMessageContent);
        adminMessageMapper.updateAdminMessage(adminMessage);
        return true;
    }

    @Override
    public AdminMessage getAdminMessageById(Integer adminMessageId) {
        return adminMessageMapper.getAdminMessage(adminMessageId);
    }

    @Override
    public List<AdminMessage> getAllAdminMessage() {
        return adminMessageMapper.selectAllAdminMessage();
    }

    @Override
    public boolean removeAdminMessage(Integer adminMessageId) {
        if (adminMessageId == null || adminMessageId <= 0 || adminMessageMapper.getAdminMessage(adminMessageId) == null) {
            return false;
        } else {
            adminMessageMapper.deleteAdminMessageById(adminMessageId);
            return true;
        }
    }

    @Override
    public List<AdminMessage> getAdminMessageByTitleLike(String title) {
        return adminMessageMapper.selectAdminMessageByTitleLike(title);
    }
}
