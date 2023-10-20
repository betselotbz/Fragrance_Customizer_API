package com.example.fragrance_customizer_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InformationExistException extends RuntimeException{
    /*
     * Constructor for InformationExistException.
     *
     * @param message A message describing the specific reason for the exception
     */
    public InformationExistException(String message) {super (message);}
}
//handling cases where Information already exists
//So, when an InformationExistException is thrown in the code, it will result in an HTTP response with a status code of 409 Conflict.
