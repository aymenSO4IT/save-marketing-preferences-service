package com.example.savemarketingpreferencesservice.exception;

import lombok.Data;

@Data
public class MarketingPreferenceException extends Exception {

    private String errorMessage;
    private Integer httpStatus;

    public MarketingPreferenceException(Integer httpStatus, String errorMessage) {
        super(errorMessage);
        this.httpStatus = httpStatus;
    }
}