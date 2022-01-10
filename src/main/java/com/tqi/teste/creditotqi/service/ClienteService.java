package com.tqi.teste.creditotqi.service;


import com.tqi.teste.creditotqi.service.exceptions.ObjectNofFoundExcpetion;
import com.tqi.teste.creditotqi.model.Cliente;
import com.tqi.teste.creditotqi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired //injeção de dependência
    private ClienteRepository clienteRepository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNofFoundExcpetion(
                "Objeto não encontrado! ID: "+id+", Tipo: "+Cliente.class.getName()));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(Cliente obj) {
        obj.setId(null);
        return clienteRepository.save(obj);
    }
}
