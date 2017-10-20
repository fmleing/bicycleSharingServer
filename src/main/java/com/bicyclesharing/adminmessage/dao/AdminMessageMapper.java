package com.bicyclesharing.adminmessage.dao;

import com.bicyclesharing.adminmessage.entity.AdminMessage;

public interface AdminMessageMapper {
    int deleteByPrimaryKey(Integer adminMessageId);

    int insert(AdminMessage record);

    int insertSelective(AdminMessage record);

    AdminMessage selectByPrimaryKey(Integer adminMessageId);

    int updateByPrimaryKeySelective(AdminMessage record);

    int updateByPrimaryKeyWithBLOBs(AdminMessage record);

    int updateByPrimaryKey(AdminMessage record);
}