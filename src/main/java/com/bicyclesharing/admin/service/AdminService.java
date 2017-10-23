package com.bicyclesharing.admin.service;

import com.bicyclesharing.admin.entity.Admin;
import com.bicyclesharing.adminmessage.entity.AdminMessage;

import java.util.List;

/**
 * Created by Tomecs on 2017/10/21.
 */
public interface AdminService {
    int login(String adminName, String adminPassword);

    boolean addAdmin( String adminName, String adminPassword1, String adminPassword2, String adminEmail);

    boolean removeAdmin(Integer adminId);

    Admin getAdminById(Integer adminId);

    Admin getAdminByName(String adminName);

    List<Admin> getAllAdmin();

    List<Admin> getAdminByNameLike(String name);

    boolean editAdmin(Integer adminId, String adminName, String adminPassword, String adminEmail);

    boolean addAdminMessage( String adminMessageTitle, String adminMessageContent, Integer adminId);

    boolean editAdminMessage(Integer adminMessageId, String adminMessageTitle, String adminMessageContent);

    AdminMessage getAdminMessageById(Integer adminMessageId);

    List<AdminMessage> getAllAdminMessage();

    boolean removeAdminMessage(Integer adminMessageId);

    List<AdminMessage> getAdminMessageByTitleLike(String title);

}
