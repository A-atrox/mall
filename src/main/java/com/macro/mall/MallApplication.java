package com.macro.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 *
 * @author guoyf
 * @Date 2020/9/27
 */
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@MapperScan({"com.macro.mall.dao","com.macro.mall.controller"})
public class MallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

}
