package com.match.service.automatematchservice.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AutoMatchFirstResponse {

    @JsonProperty("transid")
    private String transId;

    @JsonProperty("eventName")
    private String eventName;

    @JsonProperty("eventTimestamp")
    private String eventTimestamp;

    @JsonProperty("serverName")
    private String serverName;

    @JsonProperty("requestMetadata")
    private RequestMetadata requestMetadata;

    @JsonProperty("response")
    private Response response;
}
