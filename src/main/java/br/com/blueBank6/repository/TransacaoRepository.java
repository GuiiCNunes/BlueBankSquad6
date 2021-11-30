package br.com.blueBank6.repository;

import br.com.blueBank6.models.Cliente;
import br.com.blueBank6.models.Transacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

	
	
	
}
