package com.tqi.teste.creditotqi.repository;

import com.tqi.teste.creditotqi.model.Cliente;
import com.tqi.teste.creditotqi.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {

    List<Emprestimo> findByClienteId(Cliente cliente);

    @Query("SELECT obj FROM Emprestimo obj WHERE obj.cliente.id = :id_cliente ORDER BY id")
    List<Emprestimo> findAllByCliente(@Param(value="id_cliente") Integer id_cliente);
}
