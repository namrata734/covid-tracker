package com.example.pandemictracker.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    String name;
    String contactNumber;
    String pinCode;
}
