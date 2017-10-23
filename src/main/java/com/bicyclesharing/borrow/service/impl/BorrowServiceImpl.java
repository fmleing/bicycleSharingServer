package com.bicyclesharing.borrow.service.impl;

import com.bicyclesharing.borrow.dao.BorrowMapper;
import com.bicyclesharing.borrow.entity.Borrow;
import com.bicyclesharing.borrow.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomecs on 2017/10/23.
 */
@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;

    @Override
    public boolean addBorrow(Integer bicycleId, Integer userId, Date borrowStartTime, Date borrowEndTime, Double borrowStartX, Double borrowStartY, Double borrowEndX, Double borrowEndY, BigDecimal cost, BigDecimal remaining) {
        if ("".equals(bicycleId) || "".equals(userId) || "".equals(borrowStartTime) || "".equals(borrowEndTime) || "".equals(borrowStartX) || "".equals(borrowStartY) || "".equals(borrowEndX) || "".equals(borrowEndY) || "".equals(cost) || "".equals(remaining)) {
            return false;
        } else {
            Borrow borrow = new Borrow(bicycleId, userId, borrowStartTime, borrowEndTime, borrowStartX, borrowStartY, borrowEndX, borrowEndY, cost, remaining);
            borrowMapper.insertBorrow(borrow);
            return true;
        }
    }

    @Override
    public void removeBorrow(Integer id) {
        borrowMapper.deleteBorrow(id);
    }

    @Override
    public List<Borrow> getAllBorrow() {
        return borrowMapper.selectAllBorrow();
    }

    @Override
    public Borrow getBorrowById(Integer id) {
        return borrowMapper.selectBorrowByBorrowId(id);
    }

    @Override
    public List<Borrow> getBorrowByBicycleId(Integer bicycleId) {
        return borrowMapper.selectBorrowByBicycleId(bicycleId);
    }

    @Override
    public Borrow getBorrowLastByBicycleId(Integer bicycleId) {
        return borrowMapper.selectBorrowLastByBicycleId(bicycleId);
    }

    @Override
    public List<Borrow> getBorrowByUserId(Integer userId) {
        return borrowMapper.selectBorrowByUserId(userId);
    }

    @Override
    public BigDecimal getBorrowCost() {
        return borrowMapper.selectBorrowCost();
    }

    @Override
    public boolean editBorrow(Integer bicycleId, Date borrowEndTime, Double borrowEndX, Double borrowEndY, BigDecimal cost, BigDecimal remaining) {
        if (bicycleId == null || borrowEndTime == null || borrowEndX == null || borrowEndY == null || cost == null || remaining == null) {
            return false;
        } else {
            Borrow borrow = borrowMapper.selectBorrowLastByBicycleId(bicycleId);
            if (borrow == null) {
                return false;
            } else {
                borrow.setBorrowEndTime(borrowEndTime);
                borrow.setBorrowEndX(borrowEndX);
                borrow.setBorrowEndY(borrowEndY);
                borrow.setCost(cost);
                borrow.setRemaining(remaining);
                borrowMapper.updateBorrow(borrow);
                return true;
            }
        }
    }
}
