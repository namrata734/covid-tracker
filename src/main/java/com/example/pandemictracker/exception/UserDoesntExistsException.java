package com.example.pandemictracker.exception;

public class UserDoesntExistsException extends Exception {
    public UserDoesntExistsException(String message) {
        super(message);
    }
}
