package ru.pet.stockservices.config.actuator;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;

@Component
@RequiredArgsConstructor
public class HealthCheck implements HealthIndicator {

    @Value("${application.healthchek.url}")
    private String healthCheckUrl;

    @Override
    public Health health() {
        try {
            URL healthUrl = new URL(healthCheckUrl);
            HttpURLConnection connection = (HttpURLConnection) healthUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.connect();
            int code = connection.getResponseCode();
            if (code == 200) {
                return Health.up().build();
            } else {
                return Health.down().withDetail("Error", "auth-login is down").build();
            }
        } catch (Exception e) {
            return Health.down().withDetail("Error", "Service Unavailable").build();
        }
    }
}