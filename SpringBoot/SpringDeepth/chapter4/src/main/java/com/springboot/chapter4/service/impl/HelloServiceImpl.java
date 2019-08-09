package com.springboot.chapter4.service.impl;

import com.springboot.chapter4.service.HelloService;

/**
 * @param
 * @param
 * @param
 * @author
 * @Title:
 * @Description:
 * @return
 * @date 2019/8/9 17:32
 * @throws
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if(name == null || name.trim() == "") {
            throw new RuntimeException("parameter is null!!");
        }
        System.out.println("hello " + name);
    }
}
