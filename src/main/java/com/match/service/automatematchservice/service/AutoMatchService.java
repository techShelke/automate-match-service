package com.match.service.automatematchservice.service;

import com.match.service.automatematchservice.contract.AutoMatchFirstResponse;
import com.match.service.automatematchservice.contract.JsonDataContract;
import com.match.service.automatematchservice.processor.AutoMatchExcelProcessor;
import com.match.service.automatematchservice.processor.AutoMatchJsonProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AutoMatchService {
    private AutoMatchExcelProcessor autoMatchExcelProcessor = new AutoMatchExcelProcessor();
    @Autowired
    private AutoMatchJsonProcessor autoMatchJsonProcessor;

    public ResponseEntity<AutoMatchFirstResponse> processRequest(JsonDataContract jsonDataContract) throws Exception {
        autoMatchExcelProcessor.readExcelFile("matchExcel");

        return null;
    }
}
