package com.example.demo.service.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class ServicePublishResource {
    private RabbitTemplate rabbitTemplate;

    public ServicePublishResource(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendResource(String resource){
        rabbitTemplate.convertAndSend("la fila","URI",resource);
    }
}
