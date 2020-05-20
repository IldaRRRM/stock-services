package ru.pet.stockservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.pet.stockservices.dto.UserInfoDto;
import ru.pet.stockservices.service.UserInfoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserAdminControllerImpl implements UserAdminController {

    private final UserInfoService userInfoService;

    @Override
    public ResponseEntity<UserInfoDto> createUser(UserInfoDto userInfoDto) {
        return ResponseEntity.ok(userInfoService.create(userInfoDto));
    }

    @Override
    public ResponseEntity<UserInfoDto> findUser(Long id) {
        return ResponseEntity.ok(userInfoService.findUserInfoById(id));
    }

    @Override
    public ResponseEntity<UserInfoDto> updateUser(UserInfoDto userInfoDto) {
        return ResponseEntity.ok(userInfoService.update(userInfoDto));
    }

    @Override
    public ResponseEntity deleteUser(Long id) {
        userInfoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<UserInfoDto>> getUserList() {
        return ResponseEntity.ok(userInfoService.findAll());
    }

    @Override
    public ResponseEntity<UserInfoDto> findUserByUsername(String username) {
        return ResponseEntity.ok(userInfoService.findUserInfoByUsername(username));
    }
}
