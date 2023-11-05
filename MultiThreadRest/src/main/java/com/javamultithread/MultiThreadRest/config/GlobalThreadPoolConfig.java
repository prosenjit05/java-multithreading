package com.javamultithread.MultiThreadRest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class GlobalThreadPoolConfig {

    @Bean
    public TaskExecutor globalTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(200); // Set the desired number of threads
        executor.setMaxPoolSize(400); // Set the maximum number of threads
        executor.setQueueCapacity(0); // Set the queue capacity
        executor.initialize();
        return executor;
    }
}

