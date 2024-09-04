package com.match.service.automatematchservice.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestMetadata {
    @JsonProperty("version")
    private RequestMetadataVersion version;


}
