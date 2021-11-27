package br.com.blueBank6.service;

import br.com.blueBank6.models.Conta;
import br.com.blueBank6.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    public void save(Conta conta) {
        repository.save(conta);
    }

    public Conta get(Long id) {
        return repository.findById(id).get();
    }

    public void setSaldo(String tipo, BigDecimal valor, Long id) {
        Conta conta = this.get(id);
        BigDecimal novoSaldo;
        switch (tipo) {
            case "creditar":
            case "deposito":
                novoSaldo = conta.getSaldo().add(valor);
                break;
            case "debitar":
            case  "saque":
                novoSaldo = conta.getSaldo().subtract(valor);
                break;
            default:
                novoSaldo = conta.getSaldo();
                break;
        }
        conta.setSaldo(novoSaldo);
        repository.save(conta);
    }

    public void gerenciarContas(String tipo, BigDecimal valor, Long idOrigem, Long idDestino) {
        setSaldo(tipo, valor, idOrigem);
        String tipoDestino = (tipo.equals("debitar")) ? "creditar" : "debitar";
        setSaldo(tipoDestino, valor, idDestino);
    }
}
