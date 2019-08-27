package com.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @param
 * @param
 * @param
 * @author
 * @Title:
 * @Description:
 * @return
 * @date 2019/8/14 15:40
 * @throws
 */
@Component
public class BlogProperties
{
    @Value("${mrbird.blog.name}")
    private String name;

    @Value("${mrbird.blog.title}")
    private String title;

    public String getName() {
        return name;
    }

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
