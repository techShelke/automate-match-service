package com.match.service.automatematchservice;

import com.match.service.automatematchservice.contract.JsonDataContract;
import com.match.service.automatematchservice.service.AutoMatchService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutomateMatchServiceApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AutomateMatchServiceApplication.class, args);
        AutoMatchService autoMatchService = new AutoMatchService();
        JsonDataContract jsonDataContract = new JsonDataContract();
        autoMatchService.processRequest(jsonDataContract);
    }

}
