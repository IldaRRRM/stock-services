package ru.pet.stockservices.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pet.stockservices.dto.UserInfoDto;

import java.util.List;

@RequestMapping(path = "/users/")
public interface UserAdminController {

    @PostMapping(value = "create")
    ResponseEntity<UserInfoDto> createUser(@RequestBody UserInfoDto userInfoDto);

    @GetMapping(value = "{id}")
    ResponseEntity<UserInfoDto> findUser(@PathVariable("id") Long id);

    @PatchMapping(value = "update")
    ResponseEntity<UserInfoDto> updateUser(@RequestBody UserInfoDto userInfoDto);

    @DeleteMapping(value = "delete/{id}")
    ResponseEntity deleteUser(@PathVariable("id") Long id);

    @GetMapping
    ResponseEntity<List<UserInfoDto>> getUserList();
}
