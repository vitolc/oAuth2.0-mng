package com.vitulc.oauthmng.app.errors.exceptions;

public class ConflictException extends RuntimeException {
    public ConflictException(String errorMessage) {
        super(errorMessage);
    }
}

