package br.com.blueBank6.service;

import br.com.blueBank6.models.Conta;
import br.com.blueBank6.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContaService {

    @Autowired
    private ContaRepository repository;

    public void save(Conta conta) {
        repository.save(conta);
    }

    public Conta get(Long id) {
        return repository.findById(id).get();
    }
}
