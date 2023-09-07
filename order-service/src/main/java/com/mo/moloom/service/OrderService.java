package com.mo.moloom.service;

import com.mo.moloom.mapper.OrderMapper;
import com.mo.moloom.pojo.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        return orderMapper.findById(orderId);
    }
}
