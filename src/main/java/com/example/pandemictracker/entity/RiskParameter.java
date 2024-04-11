package com.example.pandemictracker.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RiskParameter {

    String userId;
    List<SYMPTOM> symptomList;
    boolean isTravelled;
    boolean isContactedWithPositivePatient;
    boolean isPositive;
}
