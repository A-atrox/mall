package com.macro.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 *
 * @author guoyf
 * @Date 2020/9/27
 */

@Configuration
@MapperScan("com.macro.mall.mbg.mapper")
public class MyBatisConfig {
}