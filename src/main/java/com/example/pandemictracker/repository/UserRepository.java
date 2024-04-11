package com.example.pandemictracker.repository;

import com.example.pandemictracker.entity.User;
import com.example.pandemictracker.exception.UserAlreadyExistsException;
import com.example.pandemictracker.request.CreateSelfAssessmentRequest;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    Map<String, User> userMap = new HashMap<>();

    public void addUser(User user) throws UserAlreadyExistsException {
        if(userMap.containsKey(user.getContactNumber())) {
            throw new UserAlreadyExistsException("User already Exists!");
        }
        userMap.put(user.getContactNumber(), user);
    }

    public boolean isValid(String userId) {
        return userMap.containsKey(userId);
    }

    public void updatePandemicResult(String userId, boolean isCovidPositiveResult) {
        User user = userMap.get(userId);
        user.setCovidPositive(isCovidPositiveResult);
        userMap.put(userId, user);
    }

}
