package com.example.savemarketingpreferencesservice.repository;

import com.example.savemarketingpreferencesservice.entity.MarketingPreference;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketingPreferenceRepository extends MongoRepository<MarketingPreference, String> {

}

