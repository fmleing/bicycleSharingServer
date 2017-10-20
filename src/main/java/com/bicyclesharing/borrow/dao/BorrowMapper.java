package com.bicyclesharing.borrow.dao;

import com.bicyclesharing.borrow.entity.Borrow;

public interface BorrowMapper {
    int deleteByPrimaryKey(Integer borrowId);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(Integer borrowId);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);
}