package br.com.blueBank6.service;

import br.com.blueBank6.models.Conta;
import br.com.blueBank6.models.Transacao;
import br.com.blueBank6.repository.ContaRepository;
import br.com.blueBank6.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    @Autowired
    private ContaRepository contaRepository;

    public void save(Transacao transacao) {
        repository.save(transacao);
        Conta conta = contaRepository.getById(transacao.getConta().getId());
        System.out.println(conta.getSaldo());
        BigDecimal novoSaldo = conta.getSaldo().add(transacao.getValor());
        conta.setSaldo(novoSaldo);
        contaRepository.save(conta);

    }

    public List<Transacao> findAll() {
        return repository.findAll();
    }

}
