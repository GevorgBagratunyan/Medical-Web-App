package com.gevbagratunyan.medicalwebapp.services;

import com.gevbagratunyan.medicalwebapp.entity.model.Patient;
import com.gevbagratunyan.medicalwebapp.repository.PatientRepository;
import com.gevbagratunyan.medicalwebapp.services.CRUD.Create;
import com.gevbagratunyan.medicalwebapp.services.CRUD.Delete;
import com.gevbagratunyan.medicalwebapp.services.CRUD.Read;
import com.gevbagratunyan.medicalwebapp.services.CRUD.Update;
import com.gevbagratunyan.medicalwebapp.trensfer.patient.request.PatientAddRequest;
import com.gevbagratunyan.medicalwebapp.trensfer.patient.request.PatientUpdateRequest;
import com.gevbagratunyan.medicalwebapp.trensfer.patient.response.PatientResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class PatientService implements Create<PatientAddRequest, PatientResponse>,
        Read<Long,PatientResponse>,
        Update<Long, PatientUpdateRequest, PatientResponse>,
        Delete<Long> {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientResponse add(PatientAddRequest patientAddRequest) {
        Patient patient = new Patient();
        BeanUtils.copyProperties(patientAddRequest,patient);
        LocalDate birthDate = createBirthDate(patientAddRequest.getBirthDate());
        patient.setBirthDate(birthDate);
        patient.setCreatedDate(LocalDate.now());

        Patient savedPatient = patientRepository.save(patient);
        PatientResponse response = new PatientResponse();

        BeanUtils.copyProperties(savedPatient,response);
        response.setBirthDate(savedPatient.getBirthDate().toString());
        return response;
    }

    @Override
    public void delete(Long id) {
        boolean isExist = patientRepository.existsById(id);
        if(!isExist){
            throw new NoSuchElementException("Patient not found");
        }
        patientRepository.deleteById(id);
    }

    @Override
    public PatientResponse get(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new  NoSuchElementException("Patient not found"));
        return createResponse(patient);
    }

    @Override
    public PatientResponse update(Long id, PatientUpdateRequest patientUpdateRequest) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new  NoSuchElementException("Patient not found"));
        if(patientUpdateRequest.getDisease()!=null){
            patient.getDiseases().put(LocalDate.now(), patientUpdateRequest.getDisease());
        }
        if(patientUpdateRequest.getAddress()!=null){
            patient.setAddress(patientUpdateRequest.getAddress());
        }
        if(patientUpdateRequest.getMail()!=null){
            patient.setMail(patientUpdateRequest.getMail());
        }
        if(patientUpdateRequest.getTelNumber()!=null){
            patient.setTelNumber(patientUpdateRequest.getTelNumber());
        }

        patient.setUpdatedDate(LocalDate.now());
        Patient savedPatient = patientRepository.save(patient);
        return createResponse(savedPatient);
    }

    public List<Patient> getPatientsByMonth(Integer year, Integer month){
        List<Patient> all = patientRepository.findAll();
        List<Patient> filtered = null;
        for(Patient patient:all){
            if(patient.getCreatedDate().getYear()==year && patient.getCreatedDate().getMonthValue()==month){
                filtered.add(patient);
            }
        }
        return filtered;
    }

    public List<Patient> getPatientsByYear(Integer year){
        List<Patient> all = patientRepository.findAll();
        List<Patient> filtered = null;
        for(Patient patient:all){
            if(patient.getCreatedDate().getYear()==year){
                filtered.add(patient);
            }
        }
        return filtered;
    }

    private LocalDate createBirthDate(String birthDate){
        String[] bd = birthDate.split("-");
        int[] bdt = new int[3];
        for(int i=0;i<3;i++){
            bdt[i] = Integer.parseInt(bd[i]);
        }
        return LocalDate.of(bdt[0], bdt[1], bdt[2]);
    }

    private PatientResponse createResponse(Patient patient){
        PatientResponse response = new PatientResponse();
        BeanUtils.copyProperties(patient,response);
        Map<LocalDate,String> diseasesMap = patient.getDiseases();
        String diseases = null;
        for(Map.Entry<LocalDate,String> entry: diseasesMap.entrySet()){
            diseases+= entry.getKey().toString() + " - " + entry.getValue() + "\n";
        }
        response.setDiseases(diseases);
        response.setBirthDate(patient.getBirthDate().toString());
        return response;
    }

}
