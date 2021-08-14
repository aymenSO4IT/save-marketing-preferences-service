package com.example.savemarketingpreferencesservice.controller;

import com.example.savemarketingpreferencesservice.entity.MarketingPreference;
import com.example.savemarketingpreferencesservice.model.MarketingPreferenceDto;
import com.example.savemarketingpreferencesservice.service.MarketingPreferenceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.savemarketingpreferencesservice.mapper.DomainMapper.map;

@RestController
@RequestMapping(value = "/v1/marketingpreferences", produces = MediaType.APPLICATION_JSON_VALUE)
@SwaggerDefinition(tags = {@Tag( name = "Save marketing preference")})
public class MarketingPreferenceController {
    private static final Logger log = LoggerFactory.getLogger(MarketingPreferenceController.class);

    private MarketingPreferenceService marketingPreferenceService;

    public MarketingPreferenceController(final MarketingPreferenceService marketingPreferenceService) {
        this.marketingPreferenceService = marketingPreferenceService;
    }

    @ApiOperation(value = "Create new marketing preference")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MarketingPreferenceDto> create(@RequestBody MarketingPreferenceDto marketingPreference) throws Exception {
        log.info("save new marketing preference: {}", marketingPreference);
        MarketingPreference response = marketingPreferenceService.save(map(marketingPreference));
        log.info("Successfully saved new marketing preference:: {}", marketingPreference);
        return ResponseEntity.ok(map(response));
    }

    @ApiOperation(value = "Update marketing preference")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MarketingPreferenceDto> update(@PathVariable(value = "id") String id, @RequestBody MarketingPreferenceDto marketingPreference) throws Exception {
        log.info("update marketing preference: {}", marketingPreference);
        MarketingPreference response = marketingPreferenceService.update(id, map(marketingPreference));
        log.info("Successfully updated new marketing preference:: {}", marketingPreference);
        return ResponseEntity.ok(map(response));
    }
}
