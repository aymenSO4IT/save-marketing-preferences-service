package com.example.savemarketingpreferencesservice.repository;

import com.example.savemarketingpreferencesservice.entity.MarketingPreference;
import com.example.savemarketingpreferencesservice.model.MarketingPreferenceType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataMongoTest
@RunWith(SpringRunner.class)
public class MarketingPreferenceRepositoryTest {

    @Autowired
    private MarketingPreferenceRepository marketingPreferenceRepository;

    @AfterEach
    public void cleanUp() {
        this.marketingPreferenceRepository.deleteAll();
    }

    @Test
    public void createMarketingPreferenceTest() {
        //setup
        MarketingPreference marketingPreference = new MarketingPreference(MarketingPreferenceType.EMAIL, "email@gmail.com", null, null, null, null);
        //action
        MarketingPreference response = marketingPreferenceRepository.save(marketingPreference);
        //verify
        Assert.assertNotNull(response.getId());
        Assert.assertEquals(marketingPreference.getType(), MarketingPreferenceType.EMAIL);
    }

    @Test
    public void updateMarketingPreferenceTest() {
        //setup
        MarketingPreference marketingPreference = new MarketingPreference(MarketingPreferenceType.EMAIL, "email@gmail.com", null, null, null, null);
        //action
        MarketingPreference response = marketingPreferenceRepository.save(marketingPreference);
        response.setPhoneNumber("+4611231231");
        response.setType(MarketingPreferenceType.SMS);
        MarketingPreference updatedResponse = marketingPreferenceRepository.save(marketingPreference);
        //verify
        Assert.assertEquals(updatedResponse.getId(), response.getId());
        Assert.assertEquals(updatedResponse.getType(), MarketingPreferenceType.SMS);
        Assert.assertEquals(updatedResponse.getPhoneNumber(), "+4611231231");
    }
}