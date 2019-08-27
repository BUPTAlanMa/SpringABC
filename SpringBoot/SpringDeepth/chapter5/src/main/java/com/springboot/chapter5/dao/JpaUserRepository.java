package com.springboot.chapter5.dao;

import com.springboot.chapter5.pojo.User;
import com.springboot.chapter5.pojo.UserDefByAnno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @param
 * @param
 * @param
 * @author
 * @Title:
 * @Description:
 * @return
 * @date 2019/8/18 10:41
 * @throws
 */
public interface JpaUserRepository extends JpaRepository<UserDefByAnno, Long> {
    // 通过继承JpaRepository接口，默认实现了CRUD
}
