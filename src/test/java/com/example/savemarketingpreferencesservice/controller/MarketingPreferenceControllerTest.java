package com.example.savemarketingpreferencesservice.controller;

import com.example.savemarketingpreferencesservice.entity.MarketingPreference;
import com.example.savemarketingpreferencesservice.model.MarketingPreferenceType;
import com.example.savemarketingpreferencesservice.service.MarketingPreferenceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MarketingPreferenceController.class)
public class MarketingPreferenceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MarketingPreferenceService marketingPreferenceService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before()
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void createMarketingPreferenceControllerTest() throws Exception {
        //setup
        MarketingPreference marketingPreference = new MarketingPreference(MarketingPreferenceType.EMAIL, "email@gmail.com", null, null, null, null);
        marketingPreference.setId("1");
        Mockito.when(marketingPreferenceService.save(Mockito.any())).thenReturn(marketingPreference);

        //action
        mockMvc.perform(post("/v1/marketingpreferences")
                .contentType(APPLICATION_JSON_UTF8)
                .content(Files.readAllBytes(Paths.get("src/test/resources/expected/create-marketing-reference-request.json"))))
                .andExpect(status().isOk());
    }

    @Test
    public void updateMarketingPreferenceControllerTest() throws Exception {
        //setup
        MarketingPreference marketingPreference = new MarketingPreference(
                MarketingPreferenceType.EMAIL,
                "email@gmail.com",
                null,
                null,
                null,
                null);
        Mockito.when(marketingPreferenceService.update(Mockito.anyString(), Mockito.any())).thenReturn(marketingPreference);

        //action
        mockMvc.perform(put("/v1/marketingpreferences/1")
                .contentType(APPLICATION_JSON_UTF8)
                .content(Files.readAllBytes(Paths.get("src/test/resources/expected/create-marketing-reference-request.json"))))
                .andExpect(status()
                        .isOk());
    }
}
