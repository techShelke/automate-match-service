package com.match.service.automatematchservice.processor;

import com.match.service.automatematchservice.contract.AutoMatchFirstResponse;
import com.match.service.automatematchservice.contract.JsonDataContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PayPhoneServiceCaller {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.endpoint.url}")
    private String serviceEndpointUrl;

    public AutoMatchFirstResponse insertRecord(JsonDataContract request) {

        // Set headers if required
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<JsonDataContract> requestEntity = new HttpEntity<>(request, headers);

        // Make the REST call
        ResponseEntity<AutoMatchFirstResponse> responseEntity = restTemplate.exchange(
                serviceEndpointUrl,
                HttpMethod.POST,
                requestEntity,
                AutoMatchFirstResponse.class
        );
        return responseEntity.getBody();


    }
}
