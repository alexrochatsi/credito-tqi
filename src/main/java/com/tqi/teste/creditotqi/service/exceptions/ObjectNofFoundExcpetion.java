package com.tqi.teste.creditotqi.service.exceptions;

public class ObjectNofFoundExcpetion extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNofFoundExcpetion (String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNofFoundExcpetion (String message) {
        super(message);
    }
}
