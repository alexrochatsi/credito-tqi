package com.tqi.teste.creditotqi.controller;


import com.tqi.teste.creditotqi.model.Cliente;
import com.tqi.teste.creditotqi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

//permite requisicao de outros lugares
@CrossOrigin("*")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired //injeção de dependência
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = clienteService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente obj = clienteService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //persiste no banco e retorna o caminho do objeto salvo no JSON
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente) {
        cliente = clienteService.create(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

}
