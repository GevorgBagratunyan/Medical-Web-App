package com.gevbagratunyan.medicalwebapp.repository;

import com.gevbagratunyan.medicalwebapp.entity.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Long> {
}
