package com.springboot.example2;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Example2Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Example2Application.class);
        // 关闭banner字体显示
//		app.setBannerMode(Mode.OFF);
        app.run(args);
    }

}
