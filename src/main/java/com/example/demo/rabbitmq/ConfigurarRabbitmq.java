package com.example.demo.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurarRabbitmq {
    @Bean
    Queue crearCola(){
        return new Queue("procesosCola", false);
    }
    @Bean
    TopicExchange exchange(){
        return new TopicExchange("colaCambio");
    }
    @Bean
    Binding unir(Queue cola, TopicExchange exchange){
        return BindingBuilder.bind(cola).to(exchange).with("unir.#");
    }
}
