package ru.pet.stockservices;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"ru.pet.stockservice.client"})
public class UserAdmin {
    public static void main(String[] args) {
        SpringApplication.run(UserAdmin.class, args);
    }
}
