package com.example.pandemictracker.service;

import com.example.pandemictracker.entity.RiskParameter;
import com.example.pandemictracker.entity.User;
import com.example.pandemictracker.exception.UserAlreadyExistsException;
import com.example.pandemictracker.implementation.RiskCalculator;
import com.example.pandemictracker.repository.UserRepository;
import com.example.pandemictracker.request.CreateSelfAssessmentRequest;
import com.example.pandemictracker.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RiskCalculatorService riskCalculatorService;

    public User registerUser(CreateUserRequest createUserRequest) throws UserAlreadyExistsException {
        User user = User.builder()
                .name(createUserRequest.getName())
                .contactNumber(createUserRequest.getContactNumber())
                .pinCode(createUserRequest.getPinCode())
                .isCovidPositive(false)
                .build();
        userRepository.addUser(user);
        return user;
    }

    public String getRisk(CreateSelfAssessmentRequest createSelfAssessmentRequest) {
        RiskParameter riskParameter = RiskParameter.builder()
                .userId(createSelfAssessmentRequest.getUserId())
                .symptomList(createSelfAssessmentRequest.getSymptomList())
                .isTravelled(createSelfAssessmentRequest.isTravelled())
                .isContactedWithPositivePatient(createSelfAssessmentRequest.isContactedWithPositivePatient())
                .isPositive(false)
                .build();
        return riskCalculatorService.calculateRisk(riskParameter);
    }
}
