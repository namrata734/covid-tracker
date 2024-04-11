package com.example.pandemictracker.controller;

import com.example.pandemictracker.entity.User;
import com.example.pandemictracker.exception.UserAlreadyExistsException;
import com.example.pandemictracker.request.CreateSelfAssessmentRequest;
import com.example.pandemictracker.request.CreateUserRequest;
import com.example.pandemictracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/registerUser")
    public ResponseEntity<User> registerUser(@RequestBody CreateUserRequest createUserRequest) throws UserAlreadyExistsException {
        return ResponseEntity.ok().body(userService.registerUser(createUserRequest));
    }

    @PostMapping("/getRisk")
    public ResponseEntity<String> getRisk(@RequestBody CreateSelfAssessmentRequest createSelfAssessmentRequest) {
        return ResponseEntity.ok().body(userService.getRisk(createSelfAssessmentRequest));
    }

}
