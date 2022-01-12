package com.tqi.teste.creditotqi.controller;

import com.tqi.teste.creditotqi.dto.ClienteDTO;
import com.tqi.teste.creditotqi.dto.EmprestimoDTO;
import com.tqi.teste.creditotqi.model.Cliente;
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


    @GetMapping
    public ResponseEntity<List<EmprestimoDTO>> findAll(@RequestParam(value = "cliente", defaultValue = "0") Integer id_cliente) {
        List<Emprestimo> list = emprestimoService.findAll(id_cliente);
        List<EmprestimoDTO> emprestimosDTO = list.stream().map(obj -> new EmprestimoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(emprestimosDTO);
    }

    // emprestimo detalhado pelo id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Emprestimo> findById(@Valid @PathVariable Integer id) {
        Emprestimo obj = emprestimoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Emprestimo> create(@Valid @RequestParam(value = "cliente", defaultValue = "0") Integer id_cliente,
                                             @RequestBody Emprestimo obj) {
        Emprestimo newObj = emprestimoService.create(id_cliente, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/emprestimos/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmprestimoDTO> update(@Valid @PathVariable Integer id, @RequestBody EmprestimoDTO objDTO) {
        Emprestimo newObj = emprestimoService.update(id,objDTO);
        return ResponseEntity.ok().body(new EmprestimoDTO(newObj));
    }
}
