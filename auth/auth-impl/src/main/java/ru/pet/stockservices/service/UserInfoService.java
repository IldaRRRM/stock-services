package ru.pet.stockservices.service;

import ru.pet.stockservices.dto.UserInfoDto;
import ru.pet.stockservices.model.UserInfo;

import java.util.List;

public interface UserInfoService {

    UserInfoDto create(UserInfoDto userInfoDto);

    UserInfoDto update(UserInfoDto userInfoDto);

    void delete(Long userInfoId);

    void delete(UserInfo userInfo);

    List<UserInfoDto> findAll();

    UserInfoDto findUserInfoById(Long userInfoId);

    UserInfo findUserInfoByUsername(String username);

}
