package com.shutiye.demo.patients.Services;

import com.shutiye.demo.patients.entities.Patients;
import com.shutiye.demo.patients.repositories.PatientRepository;
import com.shutiye.demo.student.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

//    Save new patient
    public Patients savePatient(Patients patient){
        System.out.printf("in patient Service -> savePatient : %s \n", patient);
        return patientRepository.save(patient);
    }

//Get All Patients
    public List<Patients> getAllPatients(){
        return (List<Patients>) patientRepository.findAll();
    }

    //    Get Single patient
    public Patients getPatient(Long patientid) {
        System.out.printf("in patient Service -> getpatient : %s \n",patientid);
        return patientRepository.findById(patientid).orElse(null);
    }
}
