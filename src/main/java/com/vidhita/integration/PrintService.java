package com.vidhita.integration;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

public class PrintService {

//    public void print(String message){
//        System.out.println(message);
//    }

    public Message<String> print(Message<String> message){
        System.out.println(message.getPayload());
        MessageHeaders headers = message.getHeaders();
        headers.forEach((k,v)->System.out.println(k + ":"+v));
        return MessageBuilder.withPayload("Message From PrintService").build();
    }

}
