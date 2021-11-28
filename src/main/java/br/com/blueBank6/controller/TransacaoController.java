package br.com.blueBank6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
        try {
            transacao.setData(LocalDateTime.now());
            transacaoservice.save(transacao);
            return new ResponseEntity<>("Transação efetuada com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            String msg = e.getMessage();
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
	}
  
	@GetMapping("/listar")
	public ResponseEntity<Object> ListarTransacao() {
		return new ResponseEntity<>(transacaoservice.getTransacao(), HttpStatus.OK);
	}

}
