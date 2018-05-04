package com.springboot.running.scheduled;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 
* @ClassName: ThreadScheduledTask 
* @Description: (测试使用多线程处理定时器) 
* @author jinliguo 
* @date 2018年5月4日 下午9:17:16 
*
 */
//@Configuration
//@EnableScheduling
public class ThreadScheduledTask  implements SchedulingConfigurer{

	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		 scheduledTaskRegistrar.setScheduler(setTaskExecutors());
		 DemoRunable demoRunable = new DemoRunable();
		 scheduledTaskRegistrar.addFixedDelayTask(demoRunable, 6000);
		 scheduledTaskRegistrar.addFixedDelayTask(demoRunable, 7000);
		 scheduledTaskRegistrar.addFixedDelayTask(demoRunable, 5000);
		 scheduledTaskRegistrar.addFixedDelayTask(demoRunable, 4000);
	}
	
	@Bean(destroyMethod="shutdown")
	public Executor setTaskExecutors(){
	    return Executors.newScheduledThreadPool(3); // 3个线程来处理。
	}

}
