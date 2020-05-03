package ru.pet.stockservices.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface FirstLogin {

    @Gateway(requestChannel = "usernameChannel")
    void addBonusToUser(String username);
}
