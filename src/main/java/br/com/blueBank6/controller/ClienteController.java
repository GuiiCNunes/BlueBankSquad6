package br.com.blueBank6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.blueBank6.models.Cliente;
import br.com.blueBank6.service.ClienteService;

@RestController(value = "/")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@RequestMapping(method = RequestMethod.POST, value = "/salvar")
	public String salvar( @RequestBody Cliente cliente) {
		try {
			service.save(cliente);
			return "cadastro com sucesso";

		} catch (Exception e) {
			String msg = e.getMessage();
			return msg;
		}

	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/atualizar/{id}")
	public String atualizar(@PathVariable long id,@RequestBody Cliente cliente) {
		try {
			cliente.setId(id);
		
			service.save(cliente);
			return "Atualizado com sucesso";

		} catch (Exception e) {
			String msg = e.getMessage();
			return msg;
		}

	}
	
	
	

	@RequestMapping(method = RequestMethod.GET, value = "/listar")
	public ResponseEntity<List<Cliente>> listar() {
		return ResponseEntity.ok(service.findAll());

	}

	@RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
	public String delete(@PathVariable long id) {
		service.delete(id);
		return "Deletado com sucesso";
	}

//		@ModelAttribute("ufs")
//		public Uf[] listaDeestados() {
//			return Uf.values();
//		}
}
