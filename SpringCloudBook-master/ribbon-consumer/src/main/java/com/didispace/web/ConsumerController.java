package com.didispace.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
 
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;
    
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumerNew() {
        return helloService.hello();
    }
    
    
    /**
     * 通过MAIN类中声明的RestTemplate 实现对HELLO-SERVICE/hello的调用
     * @return
     */
    @RequestMapping(value = "/ribbon-consumer1", method = RequestMethod.GET)
    public String helloConsumer() {
    	
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }

}