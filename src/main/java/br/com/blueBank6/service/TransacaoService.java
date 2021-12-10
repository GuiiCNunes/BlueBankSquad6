package br.com.blueBank6.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.blueBank6.models.Transacao;
import br.com.blueBank6.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository repository;

	@Autowired
	private ContaService contaService;

	@Transactional
	public void save(Transacao transacao) throws IOException {
	  if (transacao.getDestino() == null) {
		  contaService.setSaldo(transacao.getTipo(), transacao.getValor(), transacao.getConta().getId());
	  } else {
		  contaService.gerenciarContas(
				  transacao.getTipo(), transacao.getValor(), transacao.getConta().getId(), transacao.getDestino().getId());
	  }
	  repository.save(transacao);
	}


	public List<Transacao> buscarTransacoes(Long contaId) {
		return repository.findAllByContaId(contaId);
	}
}
