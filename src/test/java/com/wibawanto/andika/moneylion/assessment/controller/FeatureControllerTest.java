package com.wibawanto.andika.moneylion.assessment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wibawanto.andika.moneylion.assessment.model.Feature;
import com.wibawanto.andika.moneylion.assessment.service.FeatureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author andika
 */
@WebMvcTest(FeatureController.class)
public class FeatureControllerTest {

    private static final String REGISTERED_EMAIL = "andika@wibawanto.com";
    private static final String REGISTERED_FEATURE = "feature1";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FeatureService featureService;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void givenValidUserFeature_whenGetUserCanAccessFeature_thenReturnJsonCanAccess() throws Exception {
        when(featureService.isUserHasFeature(REGISTERED_EMAIL, REGISTERED_FEATURE)).thenReturn(true);

        mvc.perform(get("/feature")
                .param("feature", REGISTERED_FEATURE).param("email", REGISTERED_EMAIL))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"canAccess\":false}"))
                .andDo(print());
    }

    @Test
    public void givenValidUserFeature_whenEnableUserFeature_thenReturnOK() throws Exception {
        when(featureService.enableUserFeature(true, REGISTERED_EMAIL, REGISTERED_FEATURE)).thenReturn(true);

        Feature feature = new Feature(REGISTERED_FEATURE, REGISTERED_EMAIL, true);

        mvc.perform(post("/feature")
                .content(mapper.writeValueAsString(feature))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
