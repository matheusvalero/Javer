package com.javer.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ClientesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientesApplication.class, args);
    }
}
