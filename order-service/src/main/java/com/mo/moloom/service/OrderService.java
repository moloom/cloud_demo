package com.mo.moloom.service;

import com.mo.moloom.mapper.OrderMapper;
import com.mo.moloom.pojo.Order;
import com.mo.moloom.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private RestTemplate restTemplate;

    private static final String URL = "http://user-service/user/";

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 获取user信息
        User user = restTemplate.getForObject(URL+order.getUserId(), User.class);
        order.setUser(user);
        return order;
    }
}
