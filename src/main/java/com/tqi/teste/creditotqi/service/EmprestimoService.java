package com.tqi.teste.creditotqi.service;

import com.tqi.teste.creditotqi.model.Cliente;
import com.tqi.teste.creditotqi.model.Emprestimo;
import com.tqi.teste.creditotqi.repository.ClienteRepository;
import com.tqi.teste.creditotqi.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired //injeção de dependência
    private EmprestimoRepository emprestimoRepository;

    @Autowired //injeção de dependência
    private ClienteService clienteService;

    public List<Emprestimo> findAll() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo findById(Integer id) {
        Optional<Emprestimo> obj = emprestimoRepository.findById(id);
        return obj.orElse(null);
    }

    public Emprestimo create(Emprestimo obj) {
        obj.setId(null);
        System.out.println("Cheguei aqui!");
        return emprestimoRepository.save(obj);
    }

    public List<Emprestimo> findAll(Integer id_cliente) {
        clienteService.findById(id_cliente);
        return emprestimoRepository.findAllByCliente(id_cliente);
    }

    public Emprestimo create(Integer id_cliente, Emprestimo obj) {
        obj.setId(null);
        Cliente cliente = clienteService.findById(id_cliente);
        obj.setCliente(cliente);
        return emprestimoRepository.save(obj);
    }
}
