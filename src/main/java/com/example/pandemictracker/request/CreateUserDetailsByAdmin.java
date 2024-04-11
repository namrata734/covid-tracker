package com.example.pandemictracker.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateUserDetailsByAdmin {
    String adminId;
    String userName;
    String contactNumber;
    String pinCode;
    @JsonProperty
    boolean isCovidPositive;
}
