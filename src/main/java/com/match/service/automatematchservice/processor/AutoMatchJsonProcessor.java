package com.match.service.automatematchservice.processor;

import com.match.service.automatematchservice.contract.ExcelDataContract;
import com.match.service.automatematchservice.contract.JsonDataContract;
import com.match.service.automatematchservice.contract.JsonDataContractInnerRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class AutoMatchJsonProcessor {
    public List<JsonDataContract> createRequestJsons(JsonDataContract mainJsonDataContract, List<ExcelDataContract> excelDataContracts) {
        List<JsonDataContract> requests = new ArrayList<>();
        for (ExcelDataContract excelData : excelDataContracts) {
            JsonDataContract jsonDataContract = new JsonDataContract();
            BeanUtils.copyProperties(mainJsonDataContract, jsonDataContract);
            JsonDataContractInnerRequest request = new JsonDataContractInnerRequest();
            request.setPhoneNumber(excelData.getAni());
            request.setAccountNumber(excelData.getAccountNumber());
            request.setSys(excelData.getSys());
            request.setPrin(excelData.getPrn());
            request.setAgent(excelData.getAgent());
            request.setPayfoneId(UUID.randomUUID().toString());
            jsonDataContract.setRequest(request);
            requests.add(jsonDataContract);
        }
        return requests;
    }
}
