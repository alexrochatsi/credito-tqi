package com.tqi.teste.creditotqi.service;

import com.tqi.teste.creditotqi.dto.EmprestimoDTO;
import com.tqi.teste.creditotqi.service.exceptions.ObjectNofFoundExcpetion;
import com.tqi.teste.creditotqi.model.Cliente;
import com.tqi.teste.creditotqi.model.Emprestimo;
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
        return obj.orElseThrow(() -> new ObjectNofFoundExcpetion(
                "Objeto não encontrado! ID: "+id+", Tipo: "+Emprestimo.class.getName()));
    }

    public Emprestimo create(Emprestimo obj) {
        obj.setId(null);
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

    public Emprestimo update(Integer id, EmprestimoDTO obj) {
        Emprestimo obj2 = findById(id);
        obj2.setDataPrimeiraParcela(obj.getDataPrimeiraParcela());
        obj2.setValor(obj.getValor());
        obj2.setQuantidadeParcelas(obj.getQuantidadeParcelas());
        return emprestimoRepository.save(obj2);
    }
}
