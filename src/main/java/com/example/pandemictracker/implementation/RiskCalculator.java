package com.example.pandemictracker.implementation;

import com.example.pandemictracker.entity.RiskParameter;

public interface RiskCalculator {

    String calculateRisk(RiskParameter riskParameter);

}
