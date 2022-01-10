package com.tqi.teste.creditotqi.controller;


import com.tqi.teste.creditotqi.model.Cliente;
import com.tqi.teste.creditotqi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired //injeção de dependência
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> clientes() {
        return clienteRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

}
