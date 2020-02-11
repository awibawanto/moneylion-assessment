package com.wibawanto.andika.moneylion.assessment.service;

import com.wibawanto.andika.moneylion.assessment.model.Feature;
import com.wibawanto.andika.moneylion.assessment.repository.JpaFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author andika
 */
@Service
public class DefaultFeatureService implements FeatureService {

    @Autowired
    private JpaFeatureRepository featureRepository;

    @Override
    public boolean isUserHasFeature(String userEmail, String featureName) {
        Optional<Feature> feature = featureRepository.findByFeatureNameAndEmail(featureName, userEmail);
        return feature.isPresent() && feature.get().isEnable();
    }

    @Override
    @Transactional
    public boolean enableUserFeature(boolean enable, String userEmail, String featureName) {
        int result = featureRepository.updateUserFeature(userEmail, featureName, enable);
        return result > 0;
    }
}
