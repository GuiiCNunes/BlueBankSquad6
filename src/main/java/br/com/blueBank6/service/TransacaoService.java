package br.com.blueBank6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import br.com.blueBank6.models.Transacao;
import br.com.blueBank6.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository repository;

	public void saveTransacao(Transacao transacao) {
		repository.save(transacao);
	}

  @Autowired
  private ContaService contaService;

  public void save(Transacao transacao) {
      contaService.setSaldo(transacao.getTipo(), transacao.getValor(), transacao.getConta().getId());
      repository.save(transacao);
  }

	public List<Transacao> getTransacao() {
		return repository.findAll();
	}

}
