package com.match.service.automatematchservice.controller;

import com.match.service.automatematchservice.contract.AutoMatchFirstResponse;
import com.match.service.automatematchservice.contract.JsonDataContract;
import com.match.service.automatematchservice.service.AutoMatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class AutoMatchController {


    @Autowired
    private AutoMatchService autoMatchService;



    @PostMapping(value = "/process", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutoMatchFirstResponse> processRequest(@RequestBody JsonDataContract jsonDataContract) throws Exception {
        return autoMatchService.processRequest();

    }
}
