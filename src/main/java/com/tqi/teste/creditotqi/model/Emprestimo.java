package com.tqi.teste.creditotqi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "O valor do empréstimo é requerido!")
    private BigDecimal valor;

    @NotNull(message = "A data da primeira parcela é requerida!")
    private LocalDate dataPrimeiraParcela;

    @NotNull
    @Max(value = 60, message = "O valor máximo de parcelas não pode ser superior a 60!")
    private int quantidadeParcelas;


    @JsonIgnore
    //deleta os emprestimos associados ao excluir o cliente
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
