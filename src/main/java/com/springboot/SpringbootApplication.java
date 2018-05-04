package com.springboot;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.springboot.running.filter.TimeFilter;

/**
该注解指定项目为springboot，由此类当作程序入口
自动装配 web 依赖的环境
**/
@SpringBootApplication
@ComponentScan(basePackages="com.springboot")
public class SpringbootApplication {
	
	
	/**
	 * 配置方法二种：启动类继承 implements ServletContextInitializer(现未启用) or WebConfing 
	 * 作用:启用Servlet 过滤器 监听器 
	 */
	 public void onStartup(ServletContext servletContext) throws ServletException {
	      // 配置 Servlet
	      //servletContext.addServlet("servletTest",new ServletTest()).addMapping("/servletTest");
	      // 配置过滤器
	      servletContext.addFilter("timeFilter",new TimeFilter()).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");
	      // 配置监听器
	      //servletContext.addListener(new ListenerTest());
     }
	
	
	 public static void main(String[] args) {
		 	// SpringApplication.run(SpringbootApplication.class, args);
		 	ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
	        //context.getBean(DBConfig.class).show();
	        //context.getBean(DataSourceProperties.class).show();
	    }

}
