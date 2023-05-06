package com.example.demo.rabbitmq.consumidor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RecibirPeticionesApp {

    public void informacionPeticion(String mensaje){
        log.info("Informacion procesada");
        log.info(mensaje);
    }
}
