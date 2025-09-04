package com.javalearn.p2_exception;

public class StudentAgeException extends Exception{
    public StudentAgeException() {
    }

    public StudentAgeException(String message) {
        super(message);
    }
}
