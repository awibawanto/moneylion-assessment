package com.wibawanto.andika.moneylion.assessment.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author andika
 */
@Entity
public class Feature {
    @Id
    private String featureName;

    @NotEmpty(message = "{email.notempty}")
    @Email(message = "{email.notempty}")
    private String email;

    private boolean enable;

    public Feature() {
    }

    public Feature(String featureName, String email, boolean enable) {
        this.featureName = featureName;
        this.email = email;
        this.enable = enable;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
