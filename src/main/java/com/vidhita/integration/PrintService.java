package com.vidhita.integration;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

public class PrintService {

    public Message<String> print(Message<String> message){
        System.out.println(message.getPayload());

        return MessageBuilder.withPayload(message.getPayload().toString()).build();
    }

}
