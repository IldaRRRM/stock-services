package ru.pet.stockservices.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Service;
import ru.pet.stockservices.service.UserInfoService;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserInfoServiceJdbc implements UserInfoService {

    private final NamedParameterJdbcOperations jdbc;

    @Override
    public void addBonusToUser(String username) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        jdbc.update("UPDATE user_info SET balance = balance + 500 WHERE upper(username) = upper(:username)", paramMap);
    }
}
