package com.tqi.teste.creditotqi.service;


import com.tqi.teste.creditotqi.dto.ClienteDTO;
import com.tqi.teste.creditotqi.service.exceptions.DataIntegrityViolationException;
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

    public Cliente update(Integer id, ClienteDTO obj) {
        Cliente obj2 = findById(id);
        obj2.setName(obj.getName());
        obj2.setCpf(obj.getCpf());
        obj2.setEmail(obj.getEmail());
        obj2.setRenda(obj.getRenda());
        obj2.setSenha(obj.getSenha());
        obj2.setEndereco(obj.getEndereco());
        return clienteRepository.save(obj2);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Cliente não pode ser deletado! Possui emprestimos assosiados!");
        }
    }
}
