package com.example.pandemictracker.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {
    String name;
    String contactNumber;
    String pinCode;
    boolean isCovidPositive;
}
