package com.example.pandemictracker.request;

import com.example.pandemictracker.entity.SYMPTOM;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CreateSelfAssessmentRequest {
    String userId;
    List<SYMPTOM> symptomList;
    @JsonProperty
    boolean isTravelled;
    @JsonProperty
    boolean isContactedWithPositivePatient;
}
