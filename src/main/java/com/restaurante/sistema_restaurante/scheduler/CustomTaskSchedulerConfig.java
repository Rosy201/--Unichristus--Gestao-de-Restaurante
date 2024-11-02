package com.restaurante.sistema_restaurante.scheduler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class CustomTaskSchedulerConfig {

    @Bean(name = "cupomTaskScheduler")
    public TaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(1);
        scheduler.setThreadNamePrefix("CupomTaskScheduler-");
        scheduler.initialize();
        return scheduler;
    }
}
