package br.com.blueBank6.service;

import br.com.blueBank6.models.Transacao;
import br.com.blueBank6.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

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
