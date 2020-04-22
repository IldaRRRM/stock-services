package ru.pet.stockservices.listener;


import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.pet.stockservices.gateway.FirstLogin;

@RequiredArgsConstructor
@Service
public class FromKafkaListener {

    private final FirstLogin firstLogin;

    @KafkaListener(topics = "first_login", groupId = "user_group")
    public void userInfoListen(ConsumerRecord<?, ?> consumerRecord) {
        firstLogin.addBonusToUser(consumerRecord.value().toString());
    }
}
