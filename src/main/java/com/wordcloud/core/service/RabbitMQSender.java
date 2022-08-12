package com.wordcloud.core.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${core.rabbitmq.exchange}")
    private String exchange;

    @Value("${core.rabbitmq.routingkey}")
    private String routingkey;

    public void sendMessage(Message message) {



        rabbitTemplate.send(exchange, routingkey, message);
    }
}
