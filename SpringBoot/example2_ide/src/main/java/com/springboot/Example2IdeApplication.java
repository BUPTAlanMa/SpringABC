package com.springboot;

import com.springboot.bean.ConfigBean;
import com.springboot.bean.TestConfigBean;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

/**
 * 该入口文件必须放在其他.java文件的同级或父级目录上
 */
@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class, TestConfigBean.class})
//@ImportResource({classpath:some-application.xml})  // 不得已时，使用xml配置的方法
public class Example2IdeApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Example2IdeApplication.class);
        app.setBannerMode(Mode.OFF);
        app.setAddCommandLineProperties(false); // 禁止发布的jar包，运行jar包时通过命令行参数修改配置
        app.run(args);
    }

}
