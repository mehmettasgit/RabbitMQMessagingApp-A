package com.rabbitmqmessagingappA.gettingreply;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class GettingReply {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private String lastResponseMessage;

    public String getLastResponseMessage() {
        return lastResponseMessage;
    }

    @RabbitListener(queues = "ListenerQueue")
    public void handleResponse(String responseMessage) {
        lastResponseMessage = responseMessage;

    }
}
