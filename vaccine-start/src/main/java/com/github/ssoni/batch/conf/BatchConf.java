package com.github.ssoni.batch.conf;

import com.github.ssoni.batch.service.BatchProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Configuration
@EnableAsync
@EnableScheduling
public class BatchConf {


    @Autowired
    private BatchProcess process;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    @Scheduled(fixedDelay = 60000)
//    public void runJob() {
//        System.out.println("Time:"+LocalDateTime.now());
//        process.process();
//    }
}
