package com.rabbitmqmessagingappA.services;

import com.rabbitmqmessagingappA.entities.UserData;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServices {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    public RabbitMQServices(AmqpTemplate amqpTemplate){
        this.amqpTemplate=amqpTemplate;
    }

    public void sendMessage(UserData userdata){
        amqpTemplate.convertAndSend("ExchangeforRabbitMQ","routingKeyRabbitMQ",userdata.getJsonData());
    }
}
