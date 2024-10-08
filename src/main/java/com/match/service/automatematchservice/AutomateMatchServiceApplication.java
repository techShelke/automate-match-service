package com.match.service.automatematchservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Slf4j
public class AutomateMatchServiceApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(AutomateMatchServiceApplication.class, args);

    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Starting the process");
      /*  AutoMatchService autoMatchService = context.getBean(AutoMatchService.class);
        String jsonDirectoryPath = System.getProperty("user.dir");
        String excelDirectoryPath = System.getProperty("user.dir");
        log.info("Looking for files in directory: ", jsonDirectoryPath);

        autoMatchService.processRequest(jsonDirectoryPath,excelDirectoryPath);*/

    }
}
