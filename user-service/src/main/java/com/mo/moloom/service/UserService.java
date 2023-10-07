package com.mo.moloom.service;

import com.mo.moloom.mapper.UserMapper;
import com.mo.moloom.entities.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User queryById(Long id) {
        return userMapper.findById(id);
    }
}