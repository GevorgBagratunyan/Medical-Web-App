package com.gevbagratunyan.medicalwebapp.trensfer.patient.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class PatientAddRequest {

    @NotEmpty(message = "Name should not be empty")
    @Size(min=3, max = 50, message = "Name size should  be between 3 and 50 chars")
    private String name;

    //birth date format -> "year-month-day" -> "1984-10-09"
    @NotEmpty(message = "Birth Date should not be empty")
    private String birthDate;

    @Email
    private String mail;

    private String telNumber;

    private String address;
}
