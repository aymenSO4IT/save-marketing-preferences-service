package com.example.savemarketingpreferencesservice.service;

import com.example.savemarketingpreferencesservice.entity.MarketingPreference;
import com.example.savemarketingpreferencesservice.exception.MarketingPreferenceException;
import com.example.savemarketingpreferencesservice.model.MarketingPreferenceType;
import com.example.savemarketingpreferencesservice.repository.MarketingPreferenceRepository;
import com.example.savemarketingpreferencesservice.service.impl.MarketingPreferenceServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class MarketingPreferenceServiceTest {

    @Mock
    private MarketingPreferenceRepository marketingPreferenceRepository;

    private MarketingPreferenceService marketingPreferenceService;

    @Before
    public void setup() {
        marketingPreferenceService = new MarketingPreferenceServiceImpl(marketingPreferenceRepository);;
    }

    @Test
    public void successfullyCreatedEmailMarketingPreferenceTest() throws MarketingPreferenceException {
        //setup
        MarketingPreference marketingPreference = new MarketingPreference(MarketingPreferenceType.EMAIL, "test@gmail.com", null, null, null, null);
        marketingPreference.setId("1");
        //given
        when(marketingPreferenceRepository.save(marketingPreference)).thenReturn(marketingPreference);
        MarketingPreference response = marketingPreferenceService.save(marketingPreference);

        //verify
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getId(), marketingPreference.getId());
    }

    @Test
    public void unSuccessfullyCreatedEmailMarketingPreferenceTest() throws MarketingPreferenceException {
        //setup
        MarketingPreference marketingPreference = new MarketingPreference(MarketingPreferenceType.EMAIL, null, null, null, null, null);
        marketingPreference.setId("1");
        try {
            marketingPreferenceService.save(marketingPreference);
        } catch(MarketingPreferenceException e) {
            Assert.assertEquals("Email needs to be set when using marketing preferences EMAIL", e.getMessage());
            Assert.assertEquals(400, (int) e.getHttpStatus());
        }
    }
}
