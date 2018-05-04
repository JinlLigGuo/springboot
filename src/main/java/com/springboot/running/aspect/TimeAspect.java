package com.springboot.running.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
* @ClassName: TimeAspect 
* @Description: aop面向切面编程 
* @author jinliguo 
* @date 2018年5月4日 下午5:48:46 
*
 */
@Aspect
@Component
public class TimeAspect {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(TimeAspect.class);
	
	@Pointcut("execution(* com.springboot.running.controller..*(..))")
    public void pointMethod(){}
	
    @Around("pointMethod()")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
    	logger.info("=====Aspect处理=======");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
        	logger.info("参数为:" + arg);
        }
        long start = System.currentTimeMillis();
        //执行启动方法
        Object object = pjp.proceed();
        logger.info("Aspect 耗时:" + (System.currentTimeMillis() - start));
        return object;
    }
    
    @Before("pointMethod()")
    public void doBeforeMethod(){
    	System.out.println( "方法前");
    }
    
    @After("pointMethod()")
    public void doAfterMethod(){
    	System.out.println( "方法后");
    }
    
    
}