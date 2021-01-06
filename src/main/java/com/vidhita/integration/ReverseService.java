package com.vidhita.integration;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Locale;

public class ReverseService {

    public Message<String> reverse(String message){
        //System.out.println(new StringBuilder(message).reverse().toString());
        return MessageBuilder.withPayload(message.toUpperCase(Locale.ROOT)).build();

    }
}
