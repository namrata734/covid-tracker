package com.example.pandemictracker.service;

import com.example.pandemictracker.entity.Admin;
import com.example.pandemictracker.entity.User;
import com.example.pandemictracker.exception.AdminAlreadyExistException;
import com.example.pandemictracker.exception.AdminDoesntException;
import com.example.pandemictracker.exception.UserAlreadyExistsException;
import com.example.pandemictracker.exception.UserDoesntExistsException;
import com.example.pandemictracker.repository.AdminRepository;
import com.example.pandemictracker.repository.UserRepository;
import com.example.pandemictracker.repository.ZoneRepository;
import com.example.pandemictracker.request.CreateAdminRequest;
import com.example.pandemictracker.request.CreateUserDetailsByAdmin;
import com.example.pandemictracker.request.CreateUserRequest;
import com.example.pandemictracker.request.UpdatePandemicResultRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    private  final ZoneRepository zoneRepository;

    public Admin addAdmin(CreateAdminRequest createAdminRequest) throws AdminAlreadyExistException {
        Admin admin = Admin.builder()
                .adminId(createAdminRequest.getAdminId())
                .build();
        adminRepository.addAdmin(admin);
        return admin;
    }

    public User addUserDetails(CreateUserDetailsByAdmin createUserDetailsByAdmin) throws AdminDoesntException, UserAlreadyExistsException {
        if(adminRepository.isValid(createUserDetailsByAdmin.getAdminId())){
            User user = User.builder()
                    .name(createUserDetailsByAdmin.getUserName())
                    .contactNumber(createUserDetailsByAdmin.getContactNumber())
                    .pinCode(createUserDetailsByAdmin.getPinCode())
                    .isCovidPositive(createUserDetailsByAdmin.isCovidPositive())
                    .build();
            if(createUserDetailsByAdmin.isCovidPositive()){
                zoneRepository.addCount(createUserDetailsByAdmin.getPinCode());
            }else{
                zoneRepository.decCount(createUserDetailsByAdmin.getPinCode());
            }
            userRepository.addUser(user);
            return user;
        }else{
        throw new AdminDoesntException("Admin does not exists having adminId" + createUserDetailsByAdmin.getAdminId());
        }
    }

    public String updatePandemicResult(UpdatePandemicResultRequest updatePandemicResultRequest) throws AdminDoesntException, UserDoesntExistsException {
        if(adminRepository.isValid(updatePandemicResultRequest.getAdminId())) {
            if(userRepository.isValid(updatePandemicResultRequest.getUserId())) {
                userRepository.updatePandemicResult(updatePandemicResultRequest.getUserId(), updatePandemicResultRequest.isCovidPositive());
                return "Record of " + updatePandemicResultRequest.getUserId() + " saved successfully as " + (updatePandemicResultRequest.isCovidPositive() ? "Positive" : "Negative");
            }
            throw new UserDoesntExistsException("User with " + updatePandemicResultRequest.getUserId() + " doesn't exist!");
        }
        throw new AdminDoesntException("Admin with " + updatePandemicResultRequest.getAdminId() + " doesn't exist!");
    }

}
