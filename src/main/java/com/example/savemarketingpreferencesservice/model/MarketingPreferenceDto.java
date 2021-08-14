package com.example.savemarketingpreferencesservice.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MarketingPreferenceDto implements Serializable {

    private String id;
    private MarketingPreferenceType type;
    private String email;
    private String phoneNumber;
    private String postalCode;
    private String city;
    private String address;

    protected MarketingPreferenceDto() {
    }

    public MarketingPreferenceDto(final String id,
                                  final MarketingPreferenceType type,
                                  final String email,
                                  final String phoneNumber,
                                  final String postalCode,
                                  final String city,
                                  final String address) {
        this.id = id;
        this.type = type;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.address = address;
    }
}