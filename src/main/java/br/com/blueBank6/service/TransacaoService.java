package br.com.blueBank6.service;

import java.util.List;

import br.com.blueBank6.models.Conta;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blueBank6.models.Transacao;
import br.com.blueBank6.repository.TransacaoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository repository;

	@Autowired
	private ContaService contaService;

	@Transactional
	public void save(Transacao transacao) {
	  if (transacao.getDestino() == null) {
		  contaService.setSaldo(transacao.getTipo(), transacao.getValor(), transacao.getConta().getId());
	  } else {
		  contaService.gerenciarContas(
				  transacao.getTipo(), transacao.getValor(), transacao.getConta().getId(), transacao.getDestino().getId()
		  );
	  }
	  repository.save(transacao);
	}

	public List<String> extrato(Long contaId) {
		return repository.findAllByContaId(contaId);
	}


	public List<String> extratocpf(String cpf) {
		return repository.findAllByCpf(cpf);
	}

	public List<Transacao> getTransacao() {
		return repository.findAll();
	}

	public List<Transacao> buscarTransacoes(Conta conta) {
		return repository.findAllByConta(conta);
	}
}
