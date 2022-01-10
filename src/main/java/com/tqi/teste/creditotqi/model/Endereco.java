package com.tqi.teste.creditotqi.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Endereco {

    @NotEmpty(message = "O logradouro é requerido!")
    private String logradouro;
    private String numero;
    private String complemento;
    @NotEmpty(message = "O bairro requerido!")
    private String bairro;
    @NotEmpty(message = "O CEP é requerido!")
    private String cep;
    @NotEmpty(message = "A cidade é requerida!")
    private String cidade;
    @NotEmpty(message = "O estado é requerido!")
    private String estado;
}
