package com.example.taskscheduler.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {

	@Value("${fixedDelay.in.milliseconds}")
	private long fixedRate = 0;

	@Scheduled(fixedRateString = "${fixedDelay.in.milliseconds}")
	public void myFixedTaskSchedule() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		System.out.println("Task ran using fixed rate at: " + dtf.format(now));
		System.out.println("Delay frequency is: " + fixedRate);
	}

	@Scheduled(cron = "${cron.for.every.second}")
	public void myTaskSchedule() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println("Task ran using cron config at: " + dtf.format(now));
	}
}
