package com.match.service.automatematchservice.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response {
    @JsonProperty("code")
    private String code;

    @JsonProperty("flag")
    private String flag;

    @JsonProperty("message")
    private String message;

    @JsonProperty("operation")
    private String operation;
}
