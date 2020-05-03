package ru.pet.stockservices.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.pet.stockservices.service.UserInfoService;

@SpringBootTest
class UserInfoJdbcTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void addBonusToUser() {
    }
}