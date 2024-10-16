package com.shutiye.demo.patients.Controller;

import com.shutiye.demo.patients.Services.PatientService;
import com.shutiye.demo.patients.entities.Patients;
import com.shutiye.demo.student.entities.Student;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Patients> CreatePatient(@RequestBody @Valid Patients patients){
        return new ResponseEntity<>(patientService.savePatient(patients), HttpStatus.CREATED);
}

    @GetMapping
    public ResponseEntity<List<Patients>> getAllPatients(){
        List<Patients> patients=patientService.getAllPatients();
        if (patients.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return  ResponseEntity.ok(patients);
    }

    @GetMapping("/{patientid}")
    public ResponseEntity<Patients> getStudent(@PathVariable Long patientid){
        return new ResponseEntity<>(patientService.getPatient(patientid), HttpStatus.OK);
    }
}
