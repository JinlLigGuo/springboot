package com.springboot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
该注解指定项目为springboot，由此类当作程序入口
自动装配 web 依赖的环境
**/
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages="com.springboot")
@Configuration
public class SpringbootApplication {
	
	 public static void main(String[] args) throws IOException {
		 	ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
		 	int  port = 8999;
		 	/*BoltServer  server = (BoltServer)context.getBean("BoltServer");
			SimpleServerUserProcessor serverUserProcessor = (SimpleServerUserProcessor)context.getBean("SimpleServerUserProcessor");
			CONNECTEventProcessor serverConnectProcessor = (CONNECTEventProcessor) context.getBean("CONNECTEventProcessor");
			DISCONNECTEventProcessor serverDisConnectProcessor = (DISCONNECTEventProcessor) context.getBean("DISCONNECTEventProcessor");
			
			// 1. create a Rpc server with port assigned
			server = new BoltServer(port);
			// 2. add processor for connect and close event if you need
			server.addConnectionEventProcessor(ConnectionEventType.CONNECT, serverConnectProcessor);
			server.addConnectionEventProcessor(ConnectionEventType.CLOSE, serverDisConnectProcessor);
			// 3. register user processor for client request
			server.registerUserProcessor(serverUserProcessor);
			// 4. server start
			server.start();*/
			System.out.println("server start ok!");
		 	
	    }

}
