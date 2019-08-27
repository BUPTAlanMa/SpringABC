package com.springboot.chapter5.controller;

import com.springboot.chapter5.dao.JpaUserRepository;
import com.springboot.chapter5.pojo.UserDefByAnno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @param
 * @param
 * @param
 * @author
 * @Title:
 * @Description:
 * @return
 * @date 2019/8/18 10:43
 * @throws
 */
@Controller
@RequestMapping("/jpa")
public class JpaController {
    // 注入JPA接口，这里不需要使用实现类
    @Autowired
    private JpaUserRepository jpaUserRepository = null;

    @RequestMapping("/getUser")
    @ResponseBody
    public UserDefByAnno getUser(Long id) {
        // 使用JPA接口查询对象
        UserDefByAnno userDefByAnno = jpaUserRepository.findById(id).get();
        return userDefByAnno;
    }
}
