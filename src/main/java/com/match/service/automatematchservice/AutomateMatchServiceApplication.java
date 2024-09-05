package com.match.service.automatematchservice;

import com.match.service.automatematchservice.contract.JsonDataContract;
import com.match.service.automatematchservice.service.AutoMatchService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AutomateMatchServiceApplication implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AutomateMatchServiceApplication.class, args);
        AutoMatchService autoMatchService = new AutoMatchService();
        autoMatchService.processRequest();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
