package com.gevbagratunyan.medicalwebapp.trensfer.patient.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class PatientUpdateRequest {
    @Email
    private String mail;
    private String telNumber;
    private String address;
    private String disease;
}
