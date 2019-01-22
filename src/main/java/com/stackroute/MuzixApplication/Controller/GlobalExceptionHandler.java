package com.stackroute.MuzixApplication.Controller;

import com.stackroute.MuzixApplication.exceptions.NullValuesPassed;
import com.stackroute.MuzixApplication.exceptions.TrackAlreadyExists;
import com.stackroute.MuzixApplication.exceptions.TrackDoesNotExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Track already exists")
    @ExceptionHandler(TrackAlreadyExists.class)
    public void trackAlreadyExists(TrackAlreadyExists e) {

    }

    @ExceptionHandler(TrackDoesNotExists.class)
    public ResponseEntity<?> trackDoesNotExists(TrackDoesNotExists e) {
        return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(value= HttpStatus.CONFLICT, reason="List is empty")
    @ExceptionHandler(NullValuesPassed.class)
    public void trackListIsEmpty(NullValuesPassed e) {
    }
}
