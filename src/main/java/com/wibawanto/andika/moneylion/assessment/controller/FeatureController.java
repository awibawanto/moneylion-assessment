package com.wibawanto.andika.moneylion.assessment.controller;

import com.wibawanto.andika.moneylion.assessment.model.Feature;
import com.wibawanto.andika.moneylion.assessment.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

/**
 * @author andika
 */
@RestController
@RequestMapping("/feature")
@Validated
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @GetMapping
    public Map isUserCanAccessFeature(@Valid Feature feature) {
        return Collections.singletonMap("canAccess", featureService.isUserHasFeature(feature.getEmail(), feature.getFeatureName()));
    }

    @PostMapping
    public ResponseEntity enableUserFeature(@Valid @RequestBody Feature feature) {
        final boolean isUpdated = featureService.enableUserFeature(feature.isEnable(), feature.getEmail(), feature.getFeatureName());
        return isUpdated ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }
}
