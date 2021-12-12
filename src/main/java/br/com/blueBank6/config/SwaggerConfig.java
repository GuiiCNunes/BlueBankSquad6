package br.com.blueBank6.config;

import java.util.Arrays;
import java.util.HashSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket.select().apis(RequestHandlerSelectors.basePackage("br.com.blueBank6.controller"))
				.paths(PathSelectors.any())
				.build().apiInfo(this.informacoesApi().build())
				.consumes(new HashSet<String>(Arrays.asList("application/json")))
				.produces(new HashSet<String>(Arrays.asList("application/json")));

		return docket;
	}


	private ApiInfoBuilder informacoesApi() {
		ApiInfoBuilder informacoesApi = new ApiInfoBuilder();

		informacoesApi.title("BLUEBANK - SQUAD 6 T2 - Code Poltergeists");
		informacoesApi.description("API para cadastro de clientes no BlueBank, e extrato de suas transações");
		informacoesApi.version("1.0");

		return informacoesApi;
	}

}

