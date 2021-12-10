package br.com.blueBank6.controller;

import br.com.blueBank6.models.Cliente;
import br.com.blueBank6.models.Transacao;
import br.com.blueBank6.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class TransacaoRespostaDTO {

    @Autowired
    private ClienteService clienteService;

    private String tipo;
    private String data;
    private String valor;
    private String clienteOrigem;
    private String clienteDestino;


    public String converterSimples(Transacao transacao) {
        String tipo = transacao.getTipo();
        String data = transacao.getData().toString();
        String valor = transacao.getValor().toString();
        String txt = tipo.toUpperCase() + "  |  DATA: " + data + "  | VALOR: R$" + valor;
        return txt;
    }
    
    public String converter(Transacao transacao) {
        Long contaId = transacao.getConta().getId();
        Long destinoId = transacao.getDestino().getId();
        String clienteOrigem = clienteService.findById(contaId).get().getNomeCompleto();
        String clienteDestino = clienteService.findById(destinoId).get().getNomeCompleto();
        String tipo = transacao.getTipo();
        String data = transacao.getData().toString();
        String valor = transacao.getValor().toString();
        String txt = tipo.toUpperCase() + "  |  DATA: " + data + "  | VALOR: R$" + valor
                + "  |  ORIGEM: " + clienteOrigem + "  |  DESTINO: " + clienteDestino;
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
