package com.match.service.automatematchservice.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JsonDataContract {


    @JsonProperty("transid")
    private String transId;

    @JsonProperty("eventName")
    private String eventName;

    @JsonProperty("eventTimestamp")
    private String eventTimestamp;

    @JsonProperty("serverName")
    private String serverName;

    @JsonProperty("action")
    private String action;

    @JsonProperty("requestMetadata")
    private RequestMetadata requestMetadata;

    @JsonProperty("request")
    private JsonDataContractInnerRequest request;



}

