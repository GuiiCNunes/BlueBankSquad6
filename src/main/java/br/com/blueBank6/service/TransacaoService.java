package br.com.blueBank6.service;

import br.com.blueBank6.models.Transacao;
import br.com.blueBank6.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    @Autowired
    private ContaService contaService;

    public void save(Transacao transacao) {
        contaService.setSaldo(transacao.getTipo(), transacao.getValor(), transacao.getConta().getId());
        repository.save(transacao);
    }

    public List<Transacao> findAll() {
        return repository.findAll();
    }

}
