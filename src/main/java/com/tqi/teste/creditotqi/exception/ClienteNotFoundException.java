package com.tqi.teste.creditotqi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNotFoundException extends Exception {

    public ClienteNotFoundException(String email) {
        super("Usuario nao encontrado com email " + email);
    }

}
