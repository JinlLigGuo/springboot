package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DBConfig {
	
	 	@Value("${db.jdbc.username}")
	    private String userName;
	 	
	    @Autowired
	    private Environment environment;
	    
	    public void show() {
	        System.out.println("db.userName:" + this.userName);
	        //  通过 environment 获取 application配置。
	        System.out.println("db.password:" + this.environment.getProperty("db.jdbc.password"));
	        System.out.println("db.jdbc.url:" + this.environment.getProperty("db.jdbc.url"));
	    }

}
