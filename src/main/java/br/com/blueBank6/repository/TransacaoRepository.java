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

    @Query(value = "SELECT TIPO, VALOR, DATA_EMISSAO, ID_CONTA_DESTINO FROM TRANSACOES WHERE ID_CONTA_ORIGEM = ?1" , nativeQuery = true)
    List<String> findAllByContaId(Long contaId);



    @Query(value = "SELECT TIPO, VALOR, DATA_EMISSAO FROM TRANSACOES WHERE ID_CONTA_ORIGEM = (SELECT CONTA_ID FROM CLIENTES WHERE CPF = ?1)", nativeQuery = true)
    List<String> findAllByCpf(String cpf);

	
	List<Transacao> findAllByConta(Conta conta);
	
}
