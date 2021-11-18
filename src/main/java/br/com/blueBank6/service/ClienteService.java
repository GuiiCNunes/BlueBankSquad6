package br.com.blueBank6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blueBank6.models.Cliente;
import br.com.blueBank6.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public void save(Cliente cliente) {
		repository.save(cliente);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public List<Cliente> findAll() {
		return repository.findAll();
		// Sort.by(Sort.Direction.ASC, "nome")
	}

}