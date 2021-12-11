package br.com.blueBank6.controller;

import br.com.blueBank6.models.Cliente;
import br.com.blueBank6.models.Conta;
import br.com.blueBank6.models.Endereco;
import br.com.blueBank6.models.Rg;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void salvarCliente() throws Exception{
        // Fonte: https://stackoverflow.com/questions/20504399/testing-springs-requestbody-using-spring-mockmvc
        String url = "/cliente/salvar";
        Rg rg = new Rg();
        rg.setDataEmissao(LocalDate.now());
        rg.setNumeroRg("123a56");
        rg.setOrgaoEmissor("SSP-GO");
        Conta conta = new Conta();
        conta.setAgencia("7592");
        conta.setStatus(false);
        conta.setSenha(321654);
        Endereco endereco = new Endereco();
        endereco.setCep("74215020");
        endereco.setLogradouro("Av T7");
        endereco.setBairro("JD America");
        endereco.setNumero(1592);
        endereco.setCidade("APARECIDA DE GOIANIA");
        endereco.setUf("GO");
        endereco.setPais("Brasil");
        Cliente cliente = new Cliente();
        cliente.setNomeCompleto("Alan Luiz teixeira");
        cliente.setApelido("Alan");
        cliente.setCpf("093.947.630-40");
        cliente.setDataNascimento(LocalDate.now());
        cliente.setNomeMae("Maria");
        cliente.setRenda(BigDecimal.valueOf(500));
        cliente.setEstadoCivil("Casado");
        cliente.setEscolaridade("Superior Completo");
        cliente.setGenero("Masculino");
        cliente.setEmail("mfsouzafonseca@gmail.com");
        cliente.setTelefone("62 994026363");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(cliente);

        mvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
            .content(requestJson))
            .andExpect(status().isOk());
//        RequestBuilder request = post("/cliente/salvar").contentType("application/json").content();
//        MvcResult result = mvc.perform(request).andReturn();
//        assertEquals("Hello, World", result.getResponse().getContentAsString());
    }

    @Test
    void atualizar() {
    }

    @Test
    void listar() {
    }

    @Test
    void deletar() {
    }

    @Test
    void listarId() {
    }

    @Test
    void listarTransacao() {
    }
}