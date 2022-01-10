package com.tqi.teste.creditotqi.dto;

import com.tqi.teste.creditotqi.model.Emprestimo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTO {

    private long id;
    @NotNull(message = "O valor do empréstimo é requerido!")
    private BigDecimal valor;
    @NotNull
    @Max(value = 60, message = "O valor máximo de parcelas não pode ser superior a 60!")
    private int quantidadeParcelas;

    public EmprestimoDTO (Emprestimo obj) {
        this.id = obj.getId();
        this.valor = obj.getValor();
        this.quantidadeParcelas = obj.getQuantidadeParcelas();
    }

}
