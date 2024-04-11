package com.example.pandemictracker.repository;

import com.example.pandemictracker.entity.Admin;
import com.example.pandemictracker.exception.AdminAlreadyExistException;
import com.example.pandemictracker.exception.AdminDoesntException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AdminRepository {

    Map<String, Admin> adminMap = new HashMap<>();

    public void addAdmin(Admin admin) throws AdminAlreadyExistException {
        if(adminMap.containsKey(admin.getAdminId())) {
            throw new AdminAlreadyExistException("Admin with " + admin.getAdminId() + " already exists!");
        }
        adminMap.put(admin.getAdminId(), admin);
    }

    public boolean isValid(String adminId) {
        return adminMap.containsKey(adminId);
    }

}
