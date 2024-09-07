package com.match.service.automatematchservice.contract;

import lombok.Data;

@Data
public class PayfoneGetDetailsRequest {
    private String transld;
    private String eventName;
    private String eventTimestamp;
    private String serverName;
    private RequestMetadata requestMetadata;
    private PayfoneGetDetailsInnerRequest request;
}
