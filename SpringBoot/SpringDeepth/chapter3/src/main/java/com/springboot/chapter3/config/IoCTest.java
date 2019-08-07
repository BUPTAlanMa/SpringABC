package com.springboot.chapter3.config;
import com.springboot.chapter3.Chapter3Application;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IoCTest {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Chapter3Application.User user = ctx.getBean(Chapter3Application.User.class);
        LOGGER.info(user.getUserName());
    }
}


