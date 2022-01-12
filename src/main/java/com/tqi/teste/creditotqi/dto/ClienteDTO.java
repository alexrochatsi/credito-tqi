package com.tqi.teste.creditotqi.dto;

import com.tqi.teste.creditotqi.model.Cliente;
import com.tqi.teste.creditotqi.model.Emprestimo;
import com.tqi.teste.creditotqi.model.Endereco;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
public class ClienteDTO implements Serializable {

    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message = "O nome é requerido!")
    private String name;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String rg;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @NotNull(message = "A renda é requerida!")
    private BigDecimal renda;

    @Embedded
    private Endereco endereco;

    public ClienteDTO() {
        super();
    }

    public ClienteDTO(Cliente obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.rg = obj.getRg();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.renda = obj.getRenda();
        this.endereco = obj.getEndereco();
    }
}
