package com.tqi.teste.creditotqi.controller;

import com.tqi.teste.creditotqi.dto.EmprestimoDTO;
import com.tqi.teste.creditotqi.model.Emprestimo;
import com.tqi.teste.creditotqi.repository.EmprestimoRepository;
import com.tqi.teste.creditotqi.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


//permite requisicao de outros lugares
@CrossOrigin("*")
@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired //injeção de dependência
    private EmprestimoService emprestimoService;


    // todos os emprestimos solicitados pelo cliente
//    @GetMapping
//    public ResponseEntity<List<EmprestimoDTO>> findAll() {
//        List<Emprestimo> list = emprestimoService.findAll();
//        List<EmprestimoDTO> emprestimosDTO = list.stream().map(obj -> new EmprestimoDTO(obj)).collect(Collectors.toList());
//        return ResponseEntity.ok().body(emprestimosDTO);
//    }

    @GetMapping
    public ResponseEntity<List<EmprestimoDTO>> findAll(@RequestParam(value = "cliente", defaultValue = "0") Integer id_cliente) {
        List<Emprestimo> list = emprestimoService.findAll(id_cliente);
        List<EmprestimoDTO> emprestimosDTO = list.stream().map(obj -> new EmprestimoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(emprestimosDTO);
    }

    // emprestimo detalhado pelo id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Emprestimo> findById(@PathVariable Integer id) {
        Emprestimo obj = emprestimoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Emprestimo> create(@RequestBody Emprestimo emprestimo) {
//        emprestimo = emprestimoService.create(emprestimo);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emprestimo.getId()).toUri();
//        return ResponseEntity.created(uri).body(emprestimo);
//    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Emprestimo> create(@Valid @RequestParam(value = "cliente", defaultValue = "0") Integer id_cliente,
                                             @RequestBody Emprestimo obj) {
        Emprestimo newObj = emprestimoService.create(id_cliente, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/emprestimos/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
