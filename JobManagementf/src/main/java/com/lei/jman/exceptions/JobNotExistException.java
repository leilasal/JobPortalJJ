package com.lei.jman.exceptions;

public class JobNotExistException extends IllegalArgumentException {
    public JobNotExistException(String msg) {
        super(msg);
    }
}