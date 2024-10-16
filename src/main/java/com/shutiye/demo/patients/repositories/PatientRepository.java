package com.shutiye.demo.patients.repositories;

import com.shutiye.demo.patients.entities.Patients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patients,Long> {
}
