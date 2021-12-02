package br.com.blueBank6.repository;

import br.com.blueBank6.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository  extends JpaRepository<Conta, Long> {
    Conta findTopByOrderByIdDesc();
    long count();
}
