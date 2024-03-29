package com.springboot.chapter3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.chapter3"},
                excludeFilters = {@ComponentScan.Filter(classes = Service.class)})
public class Chapter3Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter3Application.class, args);
    }

}
