package com.vidhita.integration;

import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.aggregator.AbstractAggregatingMessageGroupProcessor;
import org.springframework.integration.store.MessageGroup;

import java.util.Map;

public class CustomAggregator extends AbstractAggregatingMessageGroupProcessor {


    @Override
    protected Object aggregatePayloads(MessageGroup messageGroup, Map<String, Object> map) {
        StringBuilder builder = new StringBuilder();
        messageGroup.getMessages().forEach( m-> {
            System.out.println(m.getHeaders().get(IntegrationMessageHeaderAccessor.CORRELATION_ID));
            builder.append(m.getPayload());
        });
        return builder.toString();
    }
}
