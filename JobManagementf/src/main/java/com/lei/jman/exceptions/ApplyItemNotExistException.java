package com.lei.jman.exceptions;

public class ApplyItemNotExistException extends IllegalArgumentException {
    public ApplyItemNotExistException(String msg) {
        super(msg);
    }
}