package br.com.blueBank6.controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwsSnsController {

	@Autowired
	private AmazonSNSClient snsClient;


	String TOPIC_ARN = "";


	@GetMapping("/addInscricao/{email}")
	public String addSubscription(@PathVariable String email) {
		SubscribeRequest request = new SubscribeRequest(TOPIC_ARN, "email", email);
		snsClient.subscribe(request);
		return "Subscription request está pendente. Para confirmar, verifique seu email:" + email;
	}

	@GetMapping("/enviarNotificacao")
	public String publishMessageToTopic(){
		PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, buildEmailBody(), "Notification: Network connectivity issue");
		snsClient.publish(publishRequest);
		return "Notificação enviada com sucesso!";
	}

	private String buildEmailBody(){
		return "Recebemos o seu cadastro!,\n" +
				"\n" +
				"\n" +
				"Você já faz parte do Blue Bank. Estamos muito felizes que você esteja fazendo parte disso com a gente!";
	}

}