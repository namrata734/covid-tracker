package com.example.pandemictracker.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UpdatePandemicResultRequest {
    String adminId;
    String userId;
    @JsonProperty
    boolean isCovidPositive;
}

