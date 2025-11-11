package com.samir.springcampus.exception;

public class TeacherNotFoundException extends RuntimeException{
    public TeacherNotFoundException(String message){
        super(message);
    }
}
