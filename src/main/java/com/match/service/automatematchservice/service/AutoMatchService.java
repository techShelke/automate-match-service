package com.match.service.automatematchservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.match.service.automatematchservice.contract.*;
import com.match.service.automatematchservice.dao.Lookup;
import com.match.service.automatematchservice.processor.AutoMatchExcelProcessor;
import com.match.service.automatematchservice.processor.AutoMatchJsonProcessor;
import com.match.service.automatematchservice.processor.PayPhoneServiceCaller;
import com.match.service.automatematchservice.repository.LookupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoMatchService {
    @Autowired
    private AutoMatchExcelProcessor autoMatchExcelProcessor;
    @Autowired
    private AutoMatchJsonProcessor autoMatchJsonProcessor;
    @Autowired
    private PayPhoneServiceCaller payPhoneServiceCaller;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LookupRepository lookupRepository;
    @Value("${getDetails.endpoint.url}")
    private String getDetailsEndpointUrl;


    public PayfoneGetDetailsResponse getDetailsByPhoneNumber(String phoneNumber) throws Exception {
        File jsonFile = new ClassPathResource("templates/getDetails.json").getFile();
        ObjectMapper objectMapper = new ObjectMapper();
        PayfoneGetDetailsRequest requestPayload = objectMapper.readValue(jsonFile, PayfoneGetDetailsRequest.class);
        requestPayload.getRequest().setPhonenumber(phoneNumber);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<PayfoneGetDetailsRequest> entity = new HttpEntity<>(requestPayload, headers);
        ResponseEntity<PayfoneGetDetailsResponse> responseEntity = restTemplate.exchange(
                getDetailsEndpointUrl, HttpMethod.POST, entity, PayfoneGetDetailsResponse.class);
        return responseEntity.getBody();
    }

    public ResponseEntity<AutoMatchFirstResponse> processRequest(String jsonDirectoryPath, String excelDirectoryPath) throws Exception {
        File jsonFile = new File(jsonDirectoryPath + "/contract.json");
        File excelFile = new File(excelDirectoryPath + "/data.xlsx");
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
//todo: I know dao shouldn't be returned but not sure what is expected so, will make the change after confirmation
    public List<Lookup> getLookupEntriesFromExcel(String excelFilePath) throws Exception {
        File excelFile = new File(excelFilePath + "/data.xlsx");
        List<ExcelDataContract> excelDataContracts = autoMatchExcelProcessor.readExcelFile(excelFile);

        List<Lookup> lookupEntries = new ArrayList<>();

        List<String> sysList = excelDataContracts.stream()
                .map(ExcelDataContract::getSys)
                .collect(Collectors.toList());
        for (String sys : sysList) {
            List<Lookup> lookupResult = lookupRepository.findBySys(sys);
            lookupEntries.addAll(lookupResult);
        }

        return lookupEntries;
    }

}
