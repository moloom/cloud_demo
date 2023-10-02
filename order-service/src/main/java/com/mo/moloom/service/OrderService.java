package com.mo.moloom.service;

import com.mo.moloom.clients.UserClient;
import com.mo.moloom.mapper.OrderMapper;
import com.mo.moloom.pojo.Order;
import com.mo.moloom.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 获取user信息
        User user = userClient.queryById(order.getUserId());
        order.setUser(user);
        return order;
    }
}
