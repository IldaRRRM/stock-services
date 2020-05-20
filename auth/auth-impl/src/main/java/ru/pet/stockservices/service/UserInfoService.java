package ru.pet.stockservices.service;

import org.springframework.security.access.prepost.PreAuthorize;
import ru.pet.stockservices.dto.UserInfoDto;
import ru.pet.stockservices.model.UserInfo;

import java.util.List;

public interface UserInfoService {

    @PreAuthorize("hasAnyAuthority('write')")
    UserInfoDto create(UserInfoDto userInfoDto);

    @PreAuthorize("hasAnyAuthority('write')")
    UserInfoDto update(UserInfoDto userInfoDto);

    @PreAuthorize("hasAnyAuthority('write')")
    void delete(Long userInfoId);

    @PreAuthorize("hasAnyAuthority('write')")
    void delete(UserInfo userInfo);

    @PreAuthorize("hasAnyAuthority('read', 'write')")
    List<UserInfoDto> findAll();

    @PreAuthorize("hasAnyAuthority('read', 'write')")
    UserInfoDto findUserInfoById(Long userInfoId);

    @PreAuthorize("hasAnyAuthority('read', 'write')")
    UserInfoDto findUserInfoByUsername(String username);

}
