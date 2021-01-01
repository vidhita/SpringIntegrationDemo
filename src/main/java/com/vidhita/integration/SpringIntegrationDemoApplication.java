package com.vidhita.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

	@Autowired
	private CustomGateway gateway;

	@Autowired
	DirectChannel inputChannel;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		gateway.print("Hello World From Gateway");
		Message<String> message = MessageBuilder.withPayload("Using Builder Pattern with Direct Channel")
				.setHeader("headerKey1","value1")
				.build();

		MessagingTemplate template = new MessagingTemplate();
		Message returnMessage = template.sendAndReceive(inputChannel,message);
		System.out.println(returnMessage.getPayload());
	}
}
