package com.springboot.bean;

// 快捷键自动导包：ctrl+shift+O

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlogProperties {
    // 测试在application.properties中自定义的属性值
    @Value("${mrbird.blog.name}")
    private String name;

    @Value("${mrbird.blog.title}")
    private String title;

    public String getName() {
        return name;
    }

    // 快速geter, seter快捷键  shift+alt+s
    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
