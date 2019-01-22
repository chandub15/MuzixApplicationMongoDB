package com.stackroute.MuzixApplication.exceptions;

public class NullValuesPassed extends Exception {
    private String message;

    public NullValuesPassed(String message){
        super(message);
        this.message=message;
    }

}
