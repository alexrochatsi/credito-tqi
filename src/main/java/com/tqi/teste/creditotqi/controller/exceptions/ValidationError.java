package com.tqi.teste.creditotqi.controller.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public ValidationError (Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public void addErrors(String fieldName,String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
