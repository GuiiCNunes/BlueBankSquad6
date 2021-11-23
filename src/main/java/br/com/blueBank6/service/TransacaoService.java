package br.com.blueBank6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blueBank6.models.Transacao;
import br.com.blueBank6.repository.TransacaoRepository;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    public void save(Transacao transacao) {
        repository.save(transacao);
    }

    public List<Transacao> findAll() {
        return repository.findAll();
    }
    
   

}

