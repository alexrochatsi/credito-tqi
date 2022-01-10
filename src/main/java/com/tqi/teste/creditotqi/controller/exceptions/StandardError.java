package com.tqi.teste.creditotqi.controller.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

    private long timestamp;
    private Integer status;
    private String error;
}
