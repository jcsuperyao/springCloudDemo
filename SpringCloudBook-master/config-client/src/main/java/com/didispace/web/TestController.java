package com.didispace.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${from}")//引入远程配置
    private String from;
    
    @Autowired
    private Environment en;

    @RequestMapping("/from1")//通过Enviroment对象获取配置
    public String from1() {
        return en.getProperty("from", "undefind");
    }
    
    @RequestMapping("/from")
    public String from() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

}