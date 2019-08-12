package com.springboot.chapter4.aspect.service.impl;

import com.springboot.chapter4.aspect.service.UserService;
import com.springboot.chapter4.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        if(user == null) {
            throw new RuntimeException("检查用户参数是否为空......");
        }
        System.out.println("id =" + user.getId());
        System.out.println("\tusername =" + user.getUsername());
        System.out.println("\tnote =" + user.getNote());
    }
}
