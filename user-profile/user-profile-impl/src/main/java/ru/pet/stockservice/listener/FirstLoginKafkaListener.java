package ru.pet.stockservice.listener;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.pet.stockservice.model.UserProfile;
import ru.pet.stockservice.repository.UserProfileRepository;

@Service
@RequiredArgsConstructor
public class FirstLoginKafkaListener {

    private final UserProfileRepository userProfileRepository;

    @KafkaListener(topics = "first_login", groupId = "user_group")
    public void userInfoListen(ConsumerRecord<?, ?> consumerRecord) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(consumerRecord.value().toString());
        userProfileRepository.save(userProfile);
    }
}