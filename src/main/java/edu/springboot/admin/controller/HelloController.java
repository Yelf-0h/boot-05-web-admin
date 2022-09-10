package edu.springboot.admin.controller;

import edu.yecheng.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yelf
 * @create 2022-09-10-17:44
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/sayhello")
    public String sayHello(){
        return helloService.sayHello("yecheng");
    }
}
