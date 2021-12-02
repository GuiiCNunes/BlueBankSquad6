package br.com.blueBank6.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.blueBank6.dto.ClienteDto;
import br.com.blueBank6.models.Cliente;
import br.com.blueBank6.service.ClienteService;

@RestController(value = "/")
public class ClienteController {

	@Autowired
	private ClienteService service;

		
	@PostMapping("/salvar")
	public ResponseEntity<Object> salvarCliente(@RequestBody ClienteDto dto) {
        try {
           
            service.save(dto.coverter());
            return new ResponseEntity<>("Cliente cadastrado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            String msg = e.getMessage();
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
	}
	
	
	
	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<Object> atualizarCliente(@PathVariable long id, @RequestBody  ClienteDto dto){
		try {
			dto.coverter().setId(id);
			service.save(dto.coverter());
			return new ResponseEntity<>("Cliente atualizado com sucesso", HttpStatus.CREATED);
		}catch(Exception e){
			String msg = e.getMessage();
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping( value = "/listar")
	public ResponseEntity<List<Cliente>> listarCliente() {
	return ResponseEntity.ok(service.findAll());

	}
	@RequestMapping(method = RequestMethod.GET, value = "/listar/{id}")
	public Optional<Cliente> listarClienteId(@PathVariable long id) {
		return service.findyById(id);
		
	}
	@RequestMapping(method = RequestMethod.GET, value = "/listar/cpf/{cpf}")
	public List<Cliente> listarClienteCpf(@PathVariable String cpf) {
		return service.findByCpf(cpf);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
	public String deletarCliente(@PathVariable long id) {
		service.delete(id);
		return "Cliente deletado com sucesso";
	}
}
