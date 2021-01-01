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
	@Qualifier("inputChannel")
	DirectChannel inputChannel;

	@Autowired
	@Qualifier("outputChannel")
	DirectChannel outputChannel;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

			outputChannel.subscribe(
				new MessageHandler() {
					@Override
					public void handleMessage(Message<?> message) throws MessagingException {
						System.out.println( message.getPayload());
					}
				}
		);
		gateway.print("Hello World From Gateway");
		Message<String> message = MessageBuilder.withPayload("Using Builder Patter with Direct Channel")
				.setHeader("headerKey1","value1")
				.build();
		inputChannel.send(message);
	}
}
