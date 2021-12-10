package br.com.blueBank6.controller;

import br.com.blueBank6.models.AwsGateway;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/gateway")
public class AwsGatewayController {

	private final List<AwsGateway> books = new ArrayList<>();

	@PostMapping
	public AwsGateway addBook(@RequestBody AwsGateway book) {
		books.add(book);
		return book;
	}

	@GetMapping
	public List<AwsGateway> getBooks() {
		return books;
	}
}

