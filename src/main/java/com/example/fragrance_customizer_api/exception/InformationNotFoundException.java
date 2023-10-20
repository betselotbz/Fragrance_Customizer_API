package com.example.fragrance_customizer_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InformationNotFoundException extends RuntimeException{

    /*
     * Constructor for InformationNotFoundException.
     *
     * @param message A message describing the specific reason for the exception
     */

    public InformationNotFoundException(String message) { //constructor tha accepts message
        super(message); //means this runtimeexception
    }
}
