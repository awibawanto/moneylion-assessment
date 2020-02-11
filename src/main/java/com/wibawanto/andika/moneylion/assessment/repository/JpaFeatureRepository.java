package com.wibawanto.andika.moneylion.assessment.repository;

import com.wibawanto.andika.moneylion.assessment.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author andika
 */
public interface JpaFeatureRepository extends JpaRepository<Feature, String> {
    Optional<Feature> findByFeatureNameAndEmail(String name, String email);

    @Modifying
    @Query("update Feature f set f.enable = ?3 where f.featureName = ?2 and f.email = ?1")
    int updateUserFeature(String userEmail, String featureName, boolean enable);
}
