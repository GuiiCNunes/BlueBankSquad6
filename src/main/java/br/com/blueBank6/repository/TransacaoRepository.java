package br.com.blueBank6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.blueBank6.models.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query(value = "SELECT * FROM transacoes WHERE ID_CONTA_ORIGEM = ?1 OR ID_CONTA_DESTINO = ?1" , nativeQuery = true)
    List<Transacao> findAllByContaId(Long contaId);	
}
