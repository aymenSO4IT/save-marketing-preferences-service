package com.example.savemarketingpreferencesservice.service;

import com.example.savemarketingpreferencesservice.entity.MarketingPreference;
import com.example.savemarketingpreferencesservice.exception.MarketingPreferenceException;

public interface MarketingPreferenceService {
    MarketingPreference save(MarketingPreference marketingPreference) throws MarketingPreferenceException;
    MarketingPreference update(String id, MarketingPreference marketingPreference) throws MarketingPreferenceException;
}
