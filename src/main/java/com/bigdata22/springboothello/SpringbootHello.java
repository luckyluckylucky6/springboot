package com.bigdata22.springboothello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ClassDescription:
 * @Author: 小王子
 * @Create: 2024/05/16 14:24
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootHello {
    public static void main(String[] args){
        SpringApplication.run(com.bigdata22.springboothello.SpringbootHello.class);
    }
}