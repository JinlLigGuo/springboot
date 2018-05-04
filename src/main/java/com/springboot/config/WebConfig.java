package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
	 * 
	* @Title: fastJsonHttpMessageConverters 
	* @Description:  整合 Fastjson框架
	* @param @return    
	* @return HttpMessageConverters    返回类型 
	* @throws
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
	
	
	/**
	 * 
	* @Title: timeFilter 
	* @Description: 过滤器
	* @param @return    
	* @return FilterRegistrationBean    返回类型 
	* @throws
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
	 	* @Title: addInterceptors 
		* @Description: 拦截器
		* @param @return    registry
		* @return 
		* @throws
	 */
	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
		 registry.addInterceptor(timeInterceptor);
     }
	
}
