package com.lei.jman.exceptions;

public class ValidationException extends RuntimeException{
	private static final long serialVersionUID = 42L;

	public ValidationException(String message) {
        super(message);
    }
	
	public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}