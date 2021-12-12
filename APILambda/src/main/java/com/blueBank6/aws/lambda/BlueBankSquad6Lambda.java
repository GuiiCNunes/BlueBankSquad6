package com.blueBank6.aws.lambda;


import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.json.JSONObject;


@SpringBootApplication
public class BlueBankSquad6Lambda {


    @Bean
    public Supplier<String> lambda() {
		return () -> "Seja bem vindo a API Code Poltergeist";
	}
    
    public static void main(String[] args) {
        SpringApplication.run(BlueBankSquad6Lambda.class, args);
    }

}
