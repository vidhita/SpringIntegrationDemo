package com.vidhita.integration;

import org.springframework.messaging.Message;

import java.util.concurrent.Future;

public interface CustomGateway {

    public Future<Message<String>> print(Message<?> message);
   //public void send(String message);

    //public String receive();
}
