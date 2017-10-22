package com.bicyclesharing.admin.service;

import com.bicyclesharing.admin.entity.Admin;

import java.util.List;

/**
 * Created by Tomecs on 2017/10/21.
 */
public interface AdminService {
    int login(String adminName, String adminPassword);

    List<Admin> getAllAdmin();
}
