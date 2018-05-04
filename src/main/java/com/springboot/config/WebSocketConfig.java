package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.springboot.running.controller.WebSocketServer;



/**
 *
* @ClassName: WebSocketConfig 
* @Description: WebSocket配置类 
* @author jinliguo 
* @date 2018年5月3日 上午11:21:45 
*
 */
@Configuration  
@EnableWebSocket  
public class WebSocketConfig implements WebSocketConfigurer {  
    @Override  
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {  
        registry.addHandler(webSocketServer(), "/webSocketServer/*"); 
    }  
  
    @Bean
    public WebSocketHandler webSocketServer() {  
        return new WebSocketServer();  
    }  
}