package com.shutiye.demo.patients.exception;

public class PatientNotfounexception extends RuntimeException{
    private String  message;
    public PatientNotfounexception(String message){
        super(message);
        this.message=message;
    }
}
