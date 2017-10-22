package com.bicyclesharing.admin.dao;

import com.bicyclesharing.admin.entity.Admin;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin selectAdminByName(String adminName);

    List<Admin> selectAllAdmin();
}