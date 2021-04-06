package com.gevbagratunyan.medicalwebapp.trensfer.patient.request;

import lombok.Data;

@Data
public class PatientAddRequest {
    private String name;
    //birth date format -> "year-month-day" -> "1984-10-09"
    private String birthDate;
    private String mail;
    private String telNumber;
    private String address;
}
