package com.match.service.automatematchservice.contract;

import lombok.Data;

@Data
public class PayfoneGetDetailsResponse {
    private String phoneNumber;
    private String lastCallDate;
}
