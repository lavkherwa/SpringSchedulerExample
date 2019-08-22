package com.example.taskscheduler.tasks;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {

	@Value("${fixedDelay.in.milliseconds}")
	private long fixedRate = 0;

	@Scheduled(fixedRate = 1000)
	public void myTaskSchedule() {
		System.out.println("Task ran at: " + System.currentTimeMillis() / 1000);
		System.out.println("Delay frequency is: " + fixedRate);
	}
}
