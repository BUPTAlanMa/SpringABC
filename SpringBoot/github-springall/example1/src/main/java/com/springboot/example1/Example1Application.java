package com.springboot.example1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Example1Application {

    @RequestMapping("/")
    String index() {
        return "hello spring boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(Example1Application.class, args);
    }
}