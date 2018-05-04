package com.springboot.running.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



/**
 * 
* @ClassName: TimeFilter 
* @Description:  消耗时间过滤器
* @author jinliguo 
* @date 2018年5月3日 下午5:21:45 
*
 */
public class TimeFilter implements Filter{

	
	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=======初始化过滤器=========");
    }
	
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        System.out.println("filter 耗时：" + (System.currentTimeMillis() - start));
    }
    
    @Override
    public void destroy() {
        System.out.println("=======销毁过滤器=========");
    }

	
}
