package com.example.savemarketingpreferencesservice.service.impl;

import com.example.savemarketingpreferencesservice.entity.MarketingPreference;
import com.example.savemarketingpreferencesservice.exception.MarketingPreferenceException;
import com.example.savemarketingpreferencesservice.repository.MarketingPreferenceRepository;
import com.example.savemarketingpreferencesservice.service.MarketingPreferenceService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class MarketingPreferenceServiceImpl implements MarketingPreferenceService {

    private final MarketingPreferenceRepository marketingPreferenceRepository;

    public MarketingPreferenceServiceImpl(MarketingPreferenceRepository marketingPreferenceRepository) {
        this.marketingPreferenceRepository = marketingPreferenceRepository;
    }

    @Override
    public MarketingPreference save(final MarketingPreference marketingPreference) throws MarketingPreferenceException {
        validatePreferencesType(marketingPreference);
        return marketingPreferenceRepository.save(marketingPreference);
    }

    @Override
    public MarketingPreference update(String id, MarketingPreference marketingPreference) throws MarketingPreferenceException {
        if(marketingPreferenceRepository.findById(id).isPresent()) {
            marketingPreference.setId(id);
            return save(marketingPreference);
        }
        throw new MarketingPreferenceException(HttpStatus.NOT_FOUND.value(), "Marketing preference with id: " + id + " not found");
    }

    private void validatePreferencesType(final MarketingPreference marketingPreference) throws MarketingPreferenceException {
        switch (marketingPreference.getType()) {
            case EMAIL:
                if(marketingPreference.getEmail() == null) {
                    throw new MarketingPreferenceException(HttpStatus.BAD_REQUEST.value(), "Email needs to be set when using marketing preferences EMAIL");
                }
                break;
            case POST:
                if (marketingPreference.getAddress() == null || marketingPreference.getCity() == null || marketingPreference.getPostalCode() == null) {
                    throw new MarketingPreferenceException(HttpStatus.BAD_REQUEST.value(), "Address, city and postal code needs to be set when using marketing preferences POST");
                }
                break;
            case SMS:
                if (marketingPreference.getPhoneNumber() == null) {
                    throw new MarketingPreferenceException(HttpStatus.BAD_REQUEST.value(), "Phone number needs to be set when using marketing preferences SMS");
                }
                break;
        }
    }
}
