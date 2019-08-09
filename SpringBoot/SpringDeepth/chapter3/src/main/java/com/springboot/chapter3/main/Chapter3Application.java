package com.springboot.chapter3.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.chapter3"})
@PropertySource(value={"classpath:jdbc.properties"}, ignoreResourceNotFound=true)
/**
 * @PropertySource 用于使用多个配置文件，指明所使用的配置文件，value的值为配置文件路径，可多个。
 * classpath表示去类文件路径下找到配置文件，但是本项目放在resources下与application.properties同级，也正常
 */
//@ImportResource(value={""})
public class Chapter3Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter3Application.class, args);
    }

}
