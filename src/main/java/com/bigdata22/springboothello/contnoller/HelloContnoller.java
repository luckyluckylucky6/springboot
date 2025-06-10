package com.bigdata22.springboothello.contnoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassDescription:
 * @Author: 小王子
 * @Create: 2025/05/16 14:24
 **/
@RestController
public class HelloContnoller {
    @RequestMapping("/hello")
    public String hello(){
        return "hello,word! ---v1.1.0";
    }
}
