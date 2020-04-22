package ru.pet.stockservices.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ru.pet.stockservices.config.kafka.KafkaGateway;
import ru.pet.stockservices.model.UserInfo;
import ru.pet.stockservices.repository.UserInfoRepository;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoginSuccessHandler implements ApplicationListener<AuthenticationSuccessEvent> {

    private static final String USER_TOPIC = "first_login";

    private final UserInfoRepository userInfoRepository;
    private final KafkaGateway kafkaGateway;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
        Authentication authentication = authenticationSuccessEvent.getAuthentication();
        if (authentication.getPrincipal() instanceof UserInfo) {
            UserInfo userInfo = (UserInfo) authentication.getPrincipal();
            if (userInfo.getLastLogin() == null) {
                kafkaGateway.sendToKafka(userInfo.getUsername(), USER_TOPIC);
            }
            userInfo.setLastLogin(LocalDateTime.now());
            userInfoRepository.save(userInfo);
        }
    }
}
