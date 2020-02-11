package com.wibawanto.andika.moneylion.assessment.service;

/**
 * @author andika
 */
public interface FeatureService {
    /**
     * Check if user with email has enabled feature
     * @param userEmail
     * @param featureName
     * @return true if user has feature with enable flag=true
     */
    boolean isUserHasFeature(String userEmail, String featureName);

    /**
     * Enable feature for a user
     * @param enable
     * @param userEmail
     * @param featureName
     * @return true if successfully update a row in database
     */
    boolean enableUserFeature(boolean enable, String userEmail, String featureName);
}
