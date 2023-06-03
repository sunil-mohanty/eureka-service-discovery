package com.ski.spring.cloud.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class ClientApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    
}
