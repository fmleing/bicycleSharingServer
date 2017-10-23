package com.bicyclesharing.recharge.service.impl;

import com.bicyclesharing.recharge.dao.RechargeMapper;
import com.bicyclesharing.recharge.entity.Recharge;
import com.bicyclesharing.recharge.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomecs on 2017/10/23.
 */
@Service
public class RechargeServiceImpl implements RechargeService {
    @Autowired
    private RechargeMapper rechargeMapper;

    @Override
    public boolean addRecharge(Integer userId, BigDecimal rechargeAmount, BigDecimal remaining, Date rechargeTime) {
        if ("".equals(userId) || "".equals(rechargeAmount) || "".equals(remaining) || "".equals(rechargeTime)) {
            return false;
        } else {
            Recharge recharge = new Recharge(userId, rechargeAmount, remaining, rechargeTime);
            rechargeMapper.insertRecharge(recharge);
            return true;
        }
    }

    @Override
    public void removeRecharge(Integer id) {
        rechargeMapper.deleteRecharge(id);
    }

    @Override
    public List<Recharge> getAllRecharge() {
        return rechargeMapper.selectAllRecharge();
    }

    @Override
    public Recharge getRechargeById(Integer id) {
        return rechargeMapper.selectRechargeById(id);
    }

    @Override
    public List<Recharge> getRechargeByUserId(Integer userId) {
        return rechargeMapper.selectRechargeByUserId(userId);
    }

    @Override
    public BigDecimal getRechargeCount() {
        return rechargeMapper.selectRechargeCount();
    }
}
