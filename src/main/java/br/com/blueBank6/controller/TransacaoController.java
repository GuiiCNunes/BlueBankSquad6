package br.com.blueBank6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.blueBank6.models.Transacao;
import br.com.blueBank6.service.TransacaoService;

@RestController
@RequestMapping(path = "/transacao")
public class TransacaoController {

	@Autowired
	private TransacaoService transacaoservice;

	@PostMapping("/salvar")
	public ResponseEntity<Object> SalvarTransacao(@RequestBody Transacao transacao) {
		TransacaoService.save(transacao);
		return new ResponseEntity<>("Transação efetuada com sucesso", HttpStatus.CREATED);
	}


  @RequestMapping(method = RequestMethod.POST, value = "/salvar")
  public String salvar(@RequestBody Transacao transacao) {
      try {
          transacao.setData(LocalDateTime.now());
          service.save(transacao);
          return "Transacão concluída.";
      } catch (Exception e) {
          String msg = e.getMessage();
          return msg;
      }
  }
  
	@GetMapping("/listar")
	public ResponseEntity<Object> ListarTransacao() {
		return new ResponseEntity<>(transacaoservice.getTransacao(), HttpStatus.OK);
	}

}
