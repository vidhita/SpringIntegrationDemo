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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

	@Autowired
	CustomGateway gateway;


	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws ExecutionException, InterruptedException {


//		gateway.print("Hello World From Gateway");
//		Message<String> message = MessageBuilder.withPayload("Using Builder Pattern with Direct Channel")
//				.setHeader("headerKey1","value1")
//				.build();
//
//		MessagingTemplate template = new MessagingTemplate();
//		Message returnMessage = template.sendAndReceive(inputChannel,message);
//		System.out.println(returnMessage.getPayload());

		List<Future<Message<String>>> futures = new ArrayList<Future<Message<String>>>();
		for (int x=0; x<10; x++){
			Message<String> message1 = MessageBuilder.withPayload("Printing Message Payload For "+x)
					.setHeader("messageNumber",x).build();
			System.out.println("Sending Message "+x);
			futures.add((Future<Message<String>>) this.gateway.print(message1));
		}

		for (Future<Message<String>> future : futures){
			System.out.println(future.get().getPayload());
		}
	}
}
