package com.example.savemarketingpreferencesservice.entity;

import com.example.savemarketingpreferencesservice.model.MarketingPreferenceType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "marketing_preferences")
public class MarketingPreference {

    @Id
    private String id;
    private MarketingPreferenceType type;
    private String email;
    private String phoneNumber;
    private String postalCode;
    private String city;
    private String address;

    public MarketingPreference(final MarketingPreferenceType type,
                               final String email,
                               final String phoneNumber,
                               final String postalCode,
                               final String city,
                               final String address) {
        this.type = type;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.address = address;
    }
}