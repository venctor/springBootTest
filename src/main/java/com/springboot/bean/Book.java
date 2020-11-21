package com.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author guangxi.dong01@hand-china.com
 * @description 测试属性注入
 * @date 2020/11/18
 */
@Component
@PropertySource(value = "classpath:book.properties",ignoreResourceNotFound=false,encoding="UTF-8")
@ConfigurationProperties(prefix = "book")

public class Book {
    private String name;
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
