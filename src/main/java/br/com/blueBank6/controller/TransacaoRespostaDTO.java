package br.com.blueBank6.controller;

import br.com.blueBank6.models.Cliente;
import br.com.blueBank6.models.Transacao;
import br.com.blueBank6.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;


public class TransacaoRespostaDTO {

    @Autowired
    private ClienteService clienteService;

    private String tipo;
    private String data;
    private String valor;
    private String clienteOrigem;
    private String clienteDestino;

    public TransacaoRespostaDTO(){

    };

    public TransacaoRespostaDTO(String tipo, LocalDateTime data, String clienteOrigem, String clienteDestino) {
    }

    public TransacaoRespostaDTO(String tipo, LocalDateTime data) {
    }

    public String converterSimples(Transacao transacao) {
        this.setTipo(transacao.getTipo());
        this.setData(transacao.getData().toString());
        this.setValor(transacao.getValor().toString());
        String txt = this.tipo.toUpperCase() + "  |  DATA: " + this.data + "  | VALOR: R$" + this.valor;
        return txt;
    }
    
    public String converter(Transacao transacao) {
        Long contaId = transacao.getConta().getId();
        Long destinoId = transacao.getDestino().getId();
        Cliente clienteOrigem = clienteService.findById(contaId).get();
        Cliente clienteDestino = clienteService.findById(destinoId).get();
        System.out.println("teste" + destinoId);
        this.setTipo(transacao.getTipo());
        this.setData(transacao.getData().toString());
        this.setValor(transacao.getValor().toString());
        this.setClienteOrigem(clienteOrigem.getNomeCompleto());
        this.setClienteDestino(clienteDestino.getNomeCompleto());
        String txt = this.tipo.toUpperCase() + "  |  DATA: " + this.data + "  | VALOR: R$" + this.valor
                + "  |  ORIGEM: " + this.clienteOrigem + "  |  DESTINO: " + this.clienteDestino;

        return txt;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getClienteOrigem() {
        return clienteOrigem;
    }

    public void setClienteOrigem(String clienteOrigem) {
        this.clienteOrigem = clienteOrigem;
    }

    public String getClienteDestino() {
        return clienteDestino;
    }

    public void setClienteDestino(String clienteDestino) {
        this.clienteDestino = clienteDestino;
    }
}
