package com.gevbagratunyan.medicalwebapp.controllers;

import com.gevbagratunyan.medicalwebapp.entity.Patient;
import com.gevbagratunyan.medicalwebapp.services.PatientService;
import com.gevbagratunyan.medicalwebapp.trensfer.patient.request.PatientAddRequest;
import com.gevbagratunyan.medicalwebapp.trensfer.patient.request.PatientUpdateRequest;
import com.gevbagratunyan.medicalwebapp.trensfer.patient.request.PatientsByDateRequest;
import com.gevbagratunyan.medicalwebapp.trensfer.patient.response.PatientResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientResponse> addPatient(@Valid @RequestBody PatientAddRequest addRequest){
        return new ResponseEntity<>(patientService.add(addRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){
        patientService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<PatientResponse> getPatient(@PathVariable Long id){
        return new ResponseEntity<>(patientService.get(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable Long id,
                                                         @Valid @RequestBody PatientUpdateRequest updateRequest){
        return new ResponseEntity<>(patientService.update(id,updateRequest), HttpStatus.OK);
    }

    @GetMapping("/patients-by-month")
    public ResponseEntity<List<Patient>> getPatientsByMonth(@Valid @RequestBody PatientsByDateRequest byDateRequest){
        List<Patient> patients = patientService.getPatientsByMonth(byDateRequest.getYear(), byDateRequest.getMonth());
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/patients-by-year")
    public ResponseEntity<List<Patient>> getPatientsByYear(@Valid @RequestBody PatientsByDateRequest byDateRequest){
        List<Patient> patients = patientService.getPatientsByYear(byDateRequest.getYear());
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

}
