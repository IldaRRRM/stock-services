package ru.pet.stockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HardwareApp {
    public static void main(String[] args) {
        SpringApplication.run(HardwareApp.class, args);
    }
}