package com.tqi.teste.creditotqi.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FieldMessage implements Serializable {

    private String fieldName;
    private String message;

}
