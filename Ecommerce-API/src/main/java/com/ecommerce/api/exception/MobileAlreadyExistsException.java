package com.ecommerce.api.exception;


public class MobileAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MobileAlreadyExistsException(String message) {
        super(message);
    }
}
