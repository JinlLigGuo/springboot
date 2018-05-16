package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
该注解指定项目为springboot，由此类当作程序入口
自动装配 web 依赖的环境
**/
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages="com.springboot")
public class SpringbootApplication {
	
	
	 public static void main(String[] args) {
		 	ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
	    }

}
