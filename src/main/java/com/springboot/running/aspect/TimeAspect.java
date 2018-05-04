package com.springboot.running.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(TimeAspect.class);
	
    @Around("execution(* com.springboot.running.controller..*(..))")
    public Object method(ProceedingJoinPoint pjp) throws Throwable {
    	logger.debug("=====Aspect处理=======");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
        	logger.debug("参数为:" + arg);
        }
        long start = System.currentTimeMillis();
        Object object = pjp.proceed();
        logger.debug("Aspect 耗时:" + (System.currentTimeMillis() - start));
        return object;
    }
}