package com.example.pandemictracker.implementation;

import com.example.pandemictracker.entity.RiskParameter;
import com.example.pandemictracker.entity.SYMPTOM;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomRiskCalculator implements RiskCalculator {

    int getCount(RiskParameter riskParameter) {
        int count = 0;
        List<SYMPTOM> symptomList = riskParameter.getSymptomList();
        boolean hasTravelledHistory = riskParameter.isTravelled();
        boolean hasContactedWithPositivePatient = riskParameter.isContactedWithPositivePatient();
        if(!symptomList.isEmpty()) {
            count++;
        }
        if(hasTravelledHistory) {
            count++;
        }
        if(hasContactedWithPositivePatient) {
            count++;
        }
        return count;
    }

    @Override
    public String calculateRisk(RiskParameter riskParameter) {
        StringBuilder result = new StringBuilder("Risk is ");
        int count = getCount(riskParameter);
        switch (count) {
            case 0:
                result.append("5%");
                break;
            case 1:
                result.append("50%");
                break;
            case 2:
                result.append("75%");
                break;
            default:
                result.append("95%");
                break;
        }
        return result.toString();
    }
}
