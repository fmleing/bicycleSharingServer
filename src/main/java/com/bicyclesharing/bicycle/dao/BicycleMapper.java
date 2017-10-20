package com.bicyclesharing.bicycle.dao;

import com.bicyclesharing.bicycle.entity.Bicycle;

public interface BicycleMapper {
    int deleteByPrimaryKey(Integer bicycleId);

    int insert(Bicycle record);

    int insertSelective(Bicycle record);

    Bicycle selectByPrimaryKey(Integer bicycleId);

    int updateByPrimaryKeySelective(Bicycle record);

    int updateByPrimaryKey(Bicycle record);
}