package com.match.service.automatematchservice.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestMetadataVersion {
    @JsonProperty("major")
    private String major;

    @JsonProperty("minor")
    private String minor;

    @JsonProperty("patch")
    private String patch;

    @JsonProperty("versionDate")
    private String versionDate;
}
