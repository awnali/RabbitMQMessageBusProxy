package com.ontech.messagebus.proxy.stream;

import com.ontech.messagebus.proxy.models.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.function.Consumer;

@Configuration
@EnableAsync
public class EventStreamConfig {

	@Bean
	public Consumer<Event> sink(){
		return InputEventStreamService::saveEventAndSendOnOriginalQueue;
	}


	@Bean("MessageTaskExecutor")
	public TaskExecutor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(40);
		executor.setQueueCapacity(30);
		executor.setMaxPoolSize(100);
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setThreadNamePrefix("messageTaskExecutor-");
		return executor;
	}
}
