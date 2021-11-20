package br.com.blueBank6.controller;

	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;
	import br.com.blueBank6.models.Cliente;
//	import br.com.blueBank6.models.Uf;
	import br.com.blueBank6.service.ClienteService;

	@RestController(value = "/")
	public class ClienteController {

		@Autowired
		private ClienteService service;

		
		  @PostMapping("/salvar") public ResponseEntity<Object> save(@RequestBody
		 Cliente cliente){
		  
		  service.save(cliente); return new ResponseEntity<>("Cliente Cadastrado",
		 HttpStatus.CREATED); }
		 
		

	/**	@RequestMapping(method = RequestMethod.POST, value = "/salvar")
		public String salvar(Cliente cliente) {

			try {
				service.save(cliente);

				return "cadastro com sucesso";

			} catch (Exception e) {
				String msg = e.getMessage();
				return msg;
			}

		}
		**/

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
