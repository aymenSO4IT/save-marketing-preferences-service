package com.example.savemarketingpreferencesservice.mapper;

import com.example.savemarketingpreferencesservice.entity.MarketingPreference;
import com.example.savemarketingpreferencesservice.model.MarketingPreferenceDto;

public class DomainMapper {

    public static MarketingPreference map(MarketingPreferenceDto marketingPreferenceDto) {
        MarketingPreference marketingPreference = new MarketingPreference(
                marketingPreferenceDto.getType(),
                marketingPreferenceDto.getEmail(),
                marketingPreferenceDto.getPhoneNumber(),
                marketingPreferenceDto.getPostalCode(),
                marketingPreferenceDto.getCity(),
                marketingPreferenceDto.getAddress());
        if(marketingPreferenceDto.getId() != null) {
            marketingPreference.setId(marketingPreferenceDto.getId());
        }
        return marketingPreference;
    }

    public static MarketingPreferenceDto map(MarketingPreference marketingPreference) {
        return new MarketingPreferenceDto(
                marketingPreference.getId(),
                marketingPreference.getType(),
                marketingPreference.getEmail(),
                marketingPreference.getPhoneNumber(),
                marketingPreference.getPostalCode(),
                marketingPreference.getCity(),
                marketingPreference.getAddress());
    }
}
