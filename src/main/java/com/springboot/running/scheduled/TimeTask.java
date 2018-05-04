package com.springboot.running.scheduled;

import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
* @ClassName: TimeTask 
* @Description: 定时任务 
* @author jinliguo 
* @date 2018年5月4日 下午8:45:39 
*
 */
//@Component
//@EnableScheduling
public class TimeTask {

	//6毫秒
	@Scheduled(fixedRate = 6000)
    public void TaskJob() {
        System.out.println("test second annotation style ..."+ new Date());
        System.out.println("===================定时器测试任务=========================");
    }

	
}
