package br.com.blueBank6.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.blueBank6.models.Cliente;
import br.com.blueBank6.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;


	@Autowired
	private ContaService contaService;

  @Transactional
	public void save(Cliente cliente) {
		if (cliente.getId() == null || cliente.getId() == 0 ) cliente.getConta().setNumeroConta(contaService.getUltimaConta());
		else cliente.setConta(contaService.findyById(cliente.getConta().getId()).get());
		repository.save(cliente);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public List<Cliente> findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}
		
	public Optional<Cliente> findById(Long id) {
		return repository.findById(id);
	}

}