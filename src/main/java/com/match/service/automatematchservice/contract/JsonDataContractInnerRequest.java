package com.match.service.automatematchservice.contract;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class JsonDataContractInnerRequest {
    @JsonProperty("accountnumber")
    private String accountNumber;

    @JsonProperty("phonenumber")
    private String phoneNumber;

    @JsonProperty("eventtype")
    private String eventType;

    @JsonProperty("loaddatetime")
    private String loadDateTime;

    @JsonProperty("carrier")
    private String carrier;

    @JsonProperty("verified")
    private String verified;

    @JsonProperty("payfoneid")
    private String payfoneId;

    @JsonProperty("linetype")
    private String lineType;

    @JsonProperty("countrycode")
    private String countryCode;

    @JsonProperty("namescore")
    private String nameScore;

    @JsonProperty("addressscore")
    private String addressScore;

    @JsonProperty("reasoncodes")
    private String reasonCodes;

    @JsonProperty("clientid")
    private String clientId;

    @JsonProperty("lastcalldate")
    private String lastCallDate;

    @JsonProperty("sys")
    private String sys;

    @JsonProperty("prin")
    private String prin;

    @JsonProperty("agent")
    private String agent;

    @JsonProperty("ssn")
    private String ssn;

    @JsonProperty("dob")
    private String dob;

    @JsonProperty("ppflag")
    private String ppFlag;

    @JsonProperty("lexid")
    private String lexId;

    @JsonProperty("syfid")
    private String syfId;

    @JsonProperty("tokenid")
    private String tokenId;

    @JsonProperty("details")
    private String details;

    @JsonProperty("eventdate")
    private String eventDate;

    @JsonProperty("eventadditionalinfo")
    private String eventAdditionalInfo;

    @JsonProperty("cif")
    private String cif;

    @JsonProperty("firstloaddate")
    private String firstLoadDate;

    @JsonProperty("firstauthdate")
    private String firstAuthDate;

    @JsonProperty("email")
    private String email;

    @JsonProperty("acct.type")
    private String acctType;
}