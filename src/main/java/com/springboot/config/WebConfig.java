package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.springboot.running.handler.TimeInterceptor;

/**
 * 
* @ClassName: WebConfig 
* @Description: web配置 
* @author jinliguo 
* @date 2018年5月3日 下午4:28:22 
*
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	
	   
    @Autowired
    private TimeInterceptor timeInterceptor;

	/**
	 * 整合 Fastjson框架
	 */
	@Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        
        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
        
        return new HttpMessageConverters(converter);
    }
	
	
	/***
	 *	 配置静态资源处理
	 */
	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/static/");
	 }
	
	/**
	 *  过滤器
	 */
	/*@Bean
	public FilterRegistrationBean timeFilter() {
	    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	    
	    TimeFilter timeFilter = new TimeFilter();
	    registrationBean.setFilter(timeFilter);
	    
	    List<String> urls = new ArrayList<>();
	    urls.add("/*");
	    registrationBean.setUrlPatterns(urls);
	    
	    return registrationBean;
	}*/
	
	/**
	 *  拦截器
	 */
	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
		 registry.addInterceptor(timeInterceptor);
     }
	
	 
/*	 
	 @Autowired
		private SimpleServerUserProcessor simpleServerUserProcessor;
		@Autowired
		private CONNECTEventProcessor cONNECTEventProcessor ;
		@Autowired
		private DISCONNECTEventProcessor dISCONNECTEventProcessor;
		
		
		*//**
		 *  sever
		 *//*
		@Bean(name="BoltServer")
		public BoltServer boltServer() {  
			
			// 1. create a Rpc server with port assigned
			BoltServer server = new BoltServer(8999);
			// 2. add processor for connect and close event if you need
			server.addConnectionEventProcessor(ConnectionEventType.CONNECT,    serverConnectProcessor);
			server.addConnectionEventProcessor(ConnectionEventType.CLOSE,   serverDisConnectProcessor);
			// 3. register user processor for client request
			server.registerUserProcessor(serverUserProcessor);
			server.addConnectionEventProcessor(ConnectionEventType.CONNECT,    cONNECTEventProcessor);
			server.addConnectionEventProcessor(ConnectionEventType.CLOSE,   dISCONNECTEventProcessor);
			// 3. register user processor for client request
			server.registerUserProcessor(simpleServerUserProcessor);
			// 4. server start
			server.start();
			
	        return server;  
	    }  
	 */
}
