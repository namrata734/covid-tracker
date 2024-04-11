package com.example.pandemictracker.service;

import com.example.pandemictracker.entity.RiskParameter;
import com.example.pandemictracker.implementation.RiskCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RiskCalculatorService {

    @Autowired
    @Qualifier("customRiskCalculator")
    private RiskCalculator riskCalculator;

    public String calculateRisk(RiskParameter riskParameter) {
        return riskCalculator.calculateRisk(riskParameter);
    }

}
