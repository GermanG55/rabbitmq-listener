package com.example.demo.controller;

import com.example.demo.service.rabbitmq.ServicePublishResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    private ServicePublishResource servicePublishResource;

    public ApplicationController(ServicePublishResource servicePublishResource) {
        this.servicePublishResource = servicePublishResource;
    }

    @GetMapping(path = "/send-resource/{resource}")
    public void sendResource(String resource){

    }
}
