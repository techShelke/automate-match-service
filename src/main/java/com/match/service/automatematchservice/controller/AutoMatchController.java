package com.match.service.automatematchservice.controller;

import com.match.service.automatematchservice.contract.AutoMatchFirstResponse;
import com.match.service.automatematchservice.contract.PayfoneGetDetailsResponse;
import com.match.service.automatematchservice.dao.Lookup;
import com.match.service.automatematchservice.service.AutoMatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class AutoMatchController {


    @Autowired
    private AutoMatchService autoMatchService;


    @PostMapping(value = "/process", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutoMatchFirstResponse> processRequest(@RequestParam String jsonDirectoryPath, @RequestParam String excelDirectoryPath) throws Exception {
        return autoMatchService.processRequest(jsonDirectoryPath, excelDirectoryPath);

    }

    @GetMapping("/getDetails")
    public ResponseEntity<PayfoneGetDetailsResponse> getDetails(@RequestParam("phoneNumber") String phoneNumber) throws Exception {
        PayfoneGetDetailsResponse response = autoMatchService.getDetailsByPhoneNumber(phoneNumber);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/lookup/check")
    public ResponseEntity<List<Lookup>> checkLookup(@RequestParam("excelFilePath") String excelFilePath) throws Exception {
        List<Lookup> lookupEntries = autoMatchService.getLookupEntriesFromExcel(excelFilePath);
        return ResponseEntity.ok(lookupEntries);
    }
}

