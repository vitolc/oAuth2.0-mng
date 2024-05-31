package com.vitulc.oauthmng.app.errors.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

