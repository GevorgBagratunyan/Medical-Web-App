package com.gevbagratunyan.medicalwebapp.trensfer.patient.response;

import lombok.Data;

@Data
public class PatientResponse {
    private String name;
    private String birthDate;
    private String mail;
    private String telNumber;
    private String address;
    private String diseases;
}
