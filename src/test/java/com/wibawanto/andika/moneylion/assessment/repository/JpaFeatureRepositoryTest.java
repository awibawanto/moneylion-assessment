package com.wibawanto.andika.moneylion.assessment.repository;

import com.wibawanto.andika.moneylion.assessment.model.Feature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author andika
 */
@DataJpaTest
public class JpaFeatureRepositoryTest {

    private static final String REGISTERED_EMAIL = "andika@wibawanto.com";
    private static final String REGISTERED_FEATURE = "feature1";

    @Autowired
    JpaFeatureRepository featureRepository;

    @Test
    public void givenInvalidFeature_whenFindByFeatureAndEmail_thenReturnEmpty() {
        Optional<Feature> feature = featureRepository.findByFeatureNameAndEmail("invalid feature", REGISTERED_EMAIL);
        assertThat(feature).isEmpty();
    }

    @Test
    public void givenInvalidEmail_whenFindByFeatureAndEmail_thenReturnEmpty() {
        Optional<Feature> feature = featureRepository.findByFeatureNameAndEmail(REGISTERED_FEATURE, "invalid email");
        assertThat(feature).isEmpty();
    }

    @Test
    public void givenRegisteredEmailAndFeature_whenFindByFeatureAndEmail_thenReturnNotEmpty() {
        Optional<Feature> feature = featureRepository.findByFeatureNameAndEmail(REGISTERED_FEATURE, REGISTERED_EMAIL);
        assertThat(feature).isNotEmpty();
    }

    @Test
    public void givenRegisteredEmailAndFeature_whenUpdateUserFeature_thenReturnChangesCount() {
        int changesCount = featureRepository.updateUserFeature(REGISTERED_EMAIL, REGISTERED_FEATURE, true);
        assertThat(changesCount).isGreaterThan(0);
    }

    @Test
    public void givenInvalidEmail_whenUpdateUserFeature_thenReturnEmptyChangesCount() {
        int changesCount = featureRepository.updateUserFeature("abcde", REGISTERED_FEATURE, true);
        assertThat(changesCount).isLessThan(1);
    }
}
