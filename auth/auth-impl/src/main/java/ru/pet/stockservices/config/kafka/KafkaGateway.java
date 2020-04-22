package ru.pet.stockservices.config.kafka;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway
public interface KafkaGateway {

    @Gateway(requestChannel = "toKafka.input")
    void sendToKafka(String payload, @Header(KafkaHeaders.TOPIC) String topic);
}
