package com.gevbagratunyan.medicalwebapp.trensfer.patient.request;

import lombok.Data;

@Data
public class PatientUpdateRequest {
    private String mail;
    private String telNumber;
    private String address;
    private String disease;
}
