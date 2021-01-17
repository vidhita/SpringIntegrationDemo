package com.vidhita.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

	@Autowired
	PersonGateway personGateway;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args)  {
		Person person = new Person(4, "Vidhita", "Deshmukh");
		this.personGateway.save(person);
		System.out.println("Message has been sent to JMS");
	}
}
