package com.karthik.relationship.exception;

public class StudentNotFound extends RuntimeException{

    public StudentNotFound(String message) {
        super(message);
    }
}
