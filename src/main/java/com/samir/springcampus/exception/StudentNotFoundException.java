package com.samir.springcampus.exception;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String message){
        super(message);
    }
}
