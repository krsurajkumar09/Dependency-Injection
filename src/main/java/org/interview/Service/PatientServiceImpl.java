package org.interview.Service;


import org.interview.Entity.Patient;
import org.interview.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

//    private final PatientRepository patientRepository;

    // Constructor Injection
//    public PatientServiceImpl(PatientRepository patientRepository) {
//        this.patientRepository = patientRepository;
//    }

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {

        Patient existing = getPatientById(id);

        existing.setName(patient.getName());
        existing.setAge(patient.getAge());
        existing.setDisease(patient.getDisease());

        return patientRepository.save(existing);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}