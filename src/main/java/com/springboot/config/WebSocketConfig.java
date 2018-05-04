package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 *
* @ClassName: WebSocketConfig 
* @Description: WebSocket配置类 
* @author jinliguo 
* @date 2018年5月3日 上午11:21:45 
*
 */
@Configuration
public class WebSocketConfig {

	 	@Bean
	    public ServerEndpointExporter serverEndpointExporter() {
	        return new ServerEndpointExporter();
	    }
	
}
