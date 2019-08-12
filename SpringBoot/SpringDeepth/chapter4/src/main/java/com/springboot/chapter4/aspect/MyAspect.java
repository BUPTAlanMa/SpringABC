package com.springboot.chapter4.aspect;

import com.springboot.chapter4.pojo.User;
import com.springboot.chapter4.validator.UserValidator;
import com.springboot.chapter4.validator.impl.UserValidatorImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
    @DeclareParents(
            value = "com.springboot.chapter4.aspect.service.impl.UserServiceImpl+", // 指向要增强功能的目标对象
            defaultImpl = UserValidatorImpl.class) // 引入增强功能的类
    public UserValidator userValidator;

    @Pointcut("execution(* com.springboot.chapter4.*.*.*.*.printUser(..)) && bean('userServiceImpl')")
    public void pointCut() {

    }

    @Before("pointCut() && args(user)")
    public void beforeParam(JointPoint point, User user) {
        Object[] args = point.getArgs();
        System.out.println("before ......");
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("before ......");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after ......");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning ......");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing ......");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before......");
        jp.proceed();
        System.out.println("around after......");
    }
}
