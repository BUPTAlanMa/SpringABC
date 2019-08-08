package com.springboot.chapter3.config;
import com.springboot.chapter3.Chapter3Application;
import com.springboot.chapter3.pojo.BusinessPerson;
import com.springboot.chapter3.pojo.User;
import com.springboot.chapter3.pojo.definition.Person;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IoCTest {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = ctx.getBean(User.class);
        LOGGER.info(user.getUserName());

        Person person = ctx.getBean(BusinessPerson.class);
        person.service();
    }
}


