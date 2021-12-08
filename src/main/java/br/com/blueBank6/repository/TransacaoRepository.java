package br.com.blueBank6.repository;

import br.com.blueBank6.models.Cliente;
import br.com.blueBank6.models.Conta;
import br.com.blueBank6.models.Transacao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query(value = "SELECT * FROM TRANSACOES WHERE ID_CONTA_ORIGEM = ?1 OR ID_CONTA_DESTINO = ?1" , nativeQuery = true)
    List<Transacao> findAllByContaId(Long contaId);


	
}
