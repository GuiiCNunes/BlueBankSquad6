package br.com.blueBank6.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blueBank6.models.Conta;
import br.com.blueBank6.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    public void save(Conta conta) {
        repository.save(conta);
    }
    
    public int getUltimaConta() {
        int numeroConta;
        if (repository.count() > 0) {
            int ultimaConta = repository.findTopByOrderByIdDesc().getNumeroConta();
            numeroConta = ultimaConta + 1;
        } else {
            numeroConta = 1;
        }
        return numeroConta;
    }

    public Conta get(Long id) {
        return repository.findById(id).get();
    }
  
    public void checarSaldo(BigDecimal atual, BigDecimal saida) throws IOException {
      if (atual.compareTo(saida) == -1)
        throw new IOException("Saldo insuficiente");
    }

    public void setSaldo(String tipo, BigDecimal valor, Long id) throws IOException {
      Conta conta = this.get(id);
      BigDecimal novoSaldo;
      switch (tipo) {
      case "deposito":
        novoSaldo = conta.getSaldo().add(valor);
        break;
      case "transferencia":
      case "saque":
        checarSaldo(conta.getSaldo(), valor);
        novoSaldo = conta.getSaldo().subtract(valor);
        break;
      default:
        throw new IOException("Método incorreto (Aceitos: deposito, saque ou transferencia)");
      }
      conta.setSaldo(novoSaldo);
      repository.save(conta);
    }

    public void gerenciarContas(String tipo, BigDecimal valor, Long idOrigem, Long idDestino) throws IOException {
      setSaldo("transferencia", valor, idOrigem);
      setSaldo("deposito", valor, idDestino);
    }

    public BigDecimal mostrarSaldo(Long contaId) {
        Conta conta = repository.getById(contaId);
        return conta.getSaldo();
    }

    public Optional<Conta> findyById(Long id) {
      return repository.findById(id);
    }
}
