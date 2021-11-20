package br.com.blueBank6.controller;

import br.com.blueBank6.models.Transacao;
import br.com.blueBank6.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

//    @RequestMapping(method = RequestMethod.POST, value = "/criar")
//    @RequestMapping(method = RequestMethod.POST, value = "/criar")
    @PostMapping(value = "/salvar")
    public String salvar(@RequestBody Transacao transacao) {
        try {
            service.save(transacao);
            return "Transação realizada.";

        } catch (Exception e) {
            String msg = e.getMessage();
            return msg;
        }

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/alterar")
    public String atualizar(@RequestBody Transacao transacao) {
        try {
            service.save(transacao);
            return "Transação atualizada com sucesso";
        } catch (Exception e) {
            String msg = e.getMessage();
            return msg;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ver")
    public ResponseEntity<List<Transacao>> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deletar/{id}")
    public String delete(@PathVariable long id) {
        service.delete(id);
        return "Deletado com sucesso";
    }

}
