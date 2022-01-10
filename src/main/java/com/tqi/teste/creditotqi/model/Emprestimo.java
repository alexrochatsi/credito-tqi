package com.tqi.teste.creditotqi.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private LocalDate dataPrimeiraParcela;

    @Column
    @Size (min = 0, max = 60)
    private int quantidadeParcelas;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
