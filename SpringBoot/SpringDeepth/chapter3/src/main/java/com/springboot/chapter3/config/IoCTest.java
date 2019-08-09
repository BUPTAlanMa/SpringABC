package com.springboot.chapter3.config;
import com.springboot.chapter3.scope.pojo.ScopeBean;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class IoCTest {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        User user = ctx.getBean(User.class);
//        LOGGER.info(user.getUserName());
//
//        Person person = ctx.getBean(BusinessPerson.class);
//        person.service();

        /**
         *独立代码块： 测试Bean生命周期
         */
       /* AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        // 关闭IoC容器
        ctx.close();
        System.out.println("关闭IoC容器");*/

        /**
         * 独立代码块，测试Bean作用域
         */
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ScopeBean scopeBean1 = ctx.getBean(ScopeBean.class);
        ScopeBean scopeBean2 = ctx.getBean(ScopeBean.class);
        System.out.println(scopeBean1 == scopeBean2);

    }
}


