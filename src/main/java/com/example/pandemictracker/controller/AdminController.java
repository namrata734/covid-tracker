package com.example.pandemictracker.controller;

import com.example.pandemictracker.entity.Admin;
import com.example.pandemictracker.entity.User;
import com.example.pandemictracker.exception.AdminAlreadyExistException;
import com.example.pandemictracker.exception.AdminDoesntException;
import com.example.pandemictracker.exception.UserAlreadyExistsException;
import com.example.pandemictracker.exception.UserDoesntExistsException;
import com.example.pandemictracker.request.CreateAdminRequest;
import com.example.pandemictracker.request.CreateUserDetailsByAdmin;
import com.example.pandemictracker.request.CreateUserRequest;
import com.example.pandemictracker.request.UpdatePandemicResultRequest;
import com.example.pandemictracker.service.AdminService;
import com.example.pandemictracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final AdminService adminService;

    @PostMapping("/addUser")
    public ResponseEntity<User> registerUser(@RequestBody CreateUserDetailsByAdmin createUserDetailsByAdmin) throws UserAlreadyExistsException, AdminDoesntException {
        return ResponseEntity.ok().body(adminService.addUserDetails(createUserDetailsByAdmin));
    }

    @PutMapping("/updateUserPandemic")
    public ResponseEntity<String> updatePandemicResult(@RequestBody UpdatePandemicResultRequest updatePandemicResultRequest) throws AdminDoesntException, UserDoesntExistsException {
        return ResponseEntity.ok().body(adminService.updatePandemicResult(updatePandemicResultRequest));
    }

    @PostMapping("/add")
    public ResponseEntity<Admin> addAdmin(@RequestBody CreateAdminRequest createAdminRequest) throws AdminAlreadyExistException {
        return ResponseEntity.ok().body(adminService.addAdmin(createAdminRequest));
    }
}
