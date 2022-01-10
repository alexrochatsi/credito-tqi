package com.tqi.teste.creditotqi.repository;

import com.tqi.teste.creditotqi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByEmail(String email);
}
