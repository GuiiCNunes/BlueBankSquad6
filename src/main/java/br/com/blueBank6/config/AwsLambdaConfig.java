package br.com.blueBank6.config;

import br.com.blueBank6.models.AwsLambda;
import br.com.blueBank6.repository.AwsLambdaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class AwsLambdaConfig {

  @Autowired
    private AwsLambdaRepository awslambdarepository;

    @Bean
    public Supplier<List<AwsLambda>> Lambdas() {
        return () -> awslambdarepository.buildLambdas();
    }

    @Bean
    public Function<String, List<AwsLambda>> findLambdaByName() {
        return (input) -> awslambdarepository.buildLambdas().stream().filter(lambda -> lambda.getName().equals(input)).collect(Collectors.toList());
    }

}
