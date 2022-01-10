package com.tqi.teste.creditotqi.controller;

import com.tqi.teste.creditotqi.model.Emprestimo;
import com.tqi.teste.creditotqi.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired //injeção de dependência
    private EmprestimoRepository emprestimoRepository;


    // todos os emprestimos solicitados pelo cliente
    @RequestMapping
    public Iterable<Emprestimo> list() {return emprestimoRepository.findAll();}

    // emprestimo detalhado pelo id
    @RequestMapping(value = "/{id}")
    public Optional<Emprestimo> findById(@PathVariable("id") Integer id) {
        return emprestimoRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Emprestimo create(@RequestBody Emprestimo emprestimo) {
        if (Period.between(emprestimo.getDataPrimeiraParcela(), LocalDate.now()).getMonths() >= 3 &&
                Period.between(emprestimo.getDataPrimeiraParcela(), LocalDate.now()).getDays() > 0 ) {
            System.out.println("A data da primeira parcela tem que ser no máximo a 3 meses do dia de hoje!");
            return emprestimo;
        } else {
            return emprestimoRepository.save(emprestimo);
        }
    }


}
