package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NexusListener {
    @RabbitListener(queues = {"la fila"})
    public void Nucleous(String application){
        System.out.println("Procesando la request de " + application);
    }
}
