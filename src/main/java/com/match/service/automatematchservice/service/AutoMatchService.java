package com.match.service.automatematchservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.match.service.automatematchservice.contract.AutoMatchFirstResponse;
import com.match.service.automatematchservice.contract.ExcelDataContract;
import com.match.service.automatematchservice.contract.JsonDataContract;
import com.match.service.automatematchservice.processor.AutoMatchExcelProcessor;
import com.match.service.automatematchservice.processor.AutoMatchJsonProcessor;
import com.match.service.automatematchservice.processor.PayPhoneServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

@Service
public class AutoMatchService {
    @Autowired
    private AutoMatchExcelProcessor autoMatchExcelProcessor;// = new AutoMatchExcelProcessor();
    @Autowired
    private AutoMatchJsonProcessor autoMatchJsonProcessor;//  = new AutoMatchJsonProcessor();
    @Autowired
    private PayPhoneServiceCaller payPhoneServiceCaller ;// = new PayPhoneServiceCaller();

    public ResponseEntity<AutoMatchFirstResponse> processRequest(File jsonFile, File excelFile) throws Exception {
        AutoMatchFirstResponse response = null;
        List<ExcelDataContract> excelDataContracts = autoMatchExcelProcessor.readExcelFile(excelFile);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonDataContract jsonDataContract = objectMapper.readValue(jsonFile, JsonDataContract.class);

        List<JsonDataContract> requestContracts = autoMatchJsonProcessor.createRequestJsons(jsonDataContract, excelDataContracts);
        for (JsonDataContract request : requestContracts) {
             response = payPhoneServiceCaller.insertRecord(request);
        }


        return ResponseEntity.ok(response);
    }


}
