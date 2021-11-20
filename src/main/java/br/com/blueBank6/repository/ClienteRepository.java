package br.com.blueBank6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blueBank6.models.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	

}