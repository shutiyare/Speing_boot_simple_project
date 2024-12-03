package com.shutiye.demo.patients.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "patients")
public class Patients {
    @Id
    Long patient_id;

    String patientname;
//    @NotBlank
    int age;
//    @NotBlank
    String gender;
//    @Email
    String email;
//    @NotBlank
    int phone_number;
//    @NotBlank
    String address;
    LocalDate created_at;



    public Patients(){}

    public Patients( Long id,String patient_name, int age, String gender, String email, int phone_number, String address) {
//        this.patient_id=id;
        this.patientname = patient_name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
    }
    public Long getPatient_id() {
        return patient_id;
    }
//
//    public void setPatient_id(Long patient_id) {
//        this.patient_id = patient_id;
//    }
    public String getPatient_name() {
        return patientname;
    }

    public void setPatient_name(String patient_name) {
        this.patientname = patient_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }
    @Override
    public String toString() {
        return "Patients{" +
                "patientId=" + patient_id +
                "patientname=" + patientname +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone_number=" + phone_number +
                ", address='" + address + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
