package com.gevbagratunyan.medicalwebapp.trensfer.patient.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class PatientsByDateRequest {

    @NotNull
    @Size(min=4, max =4)
    private Integer year;

    @NotNull
    @Min(value = 1)
    @Max(value = 12)
    private Integer month;
}
