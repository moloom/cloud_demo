package com.mo.moloom.clients;

import com.mo.moloom.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: moloom
 * @date: 2023-10-03 00:28
 * @description:
 */
@FeignClient("user-service")
public interface UserClient {
    @GetMapping("/user/{id}")
    User queryById(@PathVariable("id") Long id);
}
