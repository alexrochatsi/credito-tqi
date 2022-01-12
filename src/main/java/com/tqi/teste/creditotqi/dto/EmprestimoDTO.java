package com.tqi.teste.creditotqi.dto;

import com.tqi.teste.creditotqi.model.Emprestimo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class EmprestimoDTO {

    private Integer id;
    @NotNull(message = "O valor do empréstimo é requerido!")
    private BigDecimal valor;
    @NotNull
    @Max(value = 60, message = "O valor máximo de parcelas não pode ser superior a 60!")
    private int quantidadeParcelas;

    @NotNull(message = "A data da primeira parcela é requerida!")
    private LocalDate dataPrimeiraParcela;

    public EmprestimoDTO() {
        super();
    }
    public EmprestimoDTO (Emprestimo obj) {
        this.id = obj.getId();
        this.valor = obj.getValor();
        this.quantidadeParcelas = obj.getQuantidadeParcelas();
        this.dataPrimeiraParcela = obj.getDataPrimeiraParcela();
    }

}
