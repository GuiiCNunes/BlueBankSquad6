package br.com.blueBank6.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.SubscribeRequest;
import br.com.blueBank6.dto.ClienteDto;
import br.com.blueBank6.models.Cliente;
import br.com.blueBank6.service.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@Autowired
	private AmazonSNSClient snsClient;

	String TOPIC_ARN = "";
	
	@PostMapping("/salvar")
	public ResponseEntity<Object> salvarCliente(@RequestBody ClienteDto dto) {
		try {
			if (!service.findByCpf(dto.getCpf()).isEmpty())
				throw new IOException("CPF já cadastrado");
			SubscribeRequest request = new SubscribeRequest(TOPIC_ARN, "email", dto.getEmail());
			snsClient.subscribe(request);
			service.save(dto.coverter());
			return new ResponseEntity<>("Cadastro efetuado com sucesso", HttpStatus.CREATED);
		} catch (Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<String> atualizar(@PathVariable long id, @RequestBody ClienteDto dto) {
		try {
			dto.setId(id);
			service.save(dto.coverter());
			return new ResponseEntity<>("Cliente atualizado com sucesso", HttpStatus.CREATED);
		} catch (Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping(value = "/listar")
	public ResponseEntity<List<Cliente>> listar() {
		return ResponseEntity.ok(service.findAll());
	}

	@DeleteMapping(value = "deletar/{id}")
	public ResponseEntity<String> deletar(@PathVariable long id) {
		try {
			service.delete(id);
			return new ResponseEntity<>("Cliente deletado com sucesso", HttpStatus.CREATED);

		} catch (Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/listar/{id}")
	public Optional<Cliente> listarId(@PathVariable long id) {
		return service.findById(id);		
	}
  
	

	@GetMapping(value = "/listar/cpf/{cpf}")
	public ResponseEntity<Object> listarPorCpf(@PathVariable String cpf) {
		if (service.findByCpf(cpf).isEmpty() || service.findByCpf(cpf) == null) {
			return new ResponseEntity<>("CPF não cadastrado", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(service.findByCpf(cpf), HttpStatus.OK);
		}
	}

}
