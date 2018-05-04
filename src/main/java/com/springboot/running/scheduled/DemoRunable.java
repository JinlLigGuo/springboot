package com.springboot.running.scheduled;

import java.util.Date;

public class DemoRunable implements Runnable{

	
	public void TaskJob() {
        System.out.println("test second annotation style ..."+ new Date());
        System.out.println("===================定时器测试任务=========================");
    }
	
	@Override
	public void run() {
		this.TaskJob();
	}

}
