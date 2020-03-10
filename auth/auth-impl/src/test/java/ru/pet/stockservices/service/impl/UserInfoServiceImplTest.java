package ru.pet.stockservices.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.pet.stockservices.dto.PermissionDto;
import ru.pet.stockservices.dto.RoleDto;
import ru.pet.stockservices.dto.UserInfoDto;
import ru.pet.stockservices.model.UserInfo;
import ru.pet.stockservices.service.UserInfoService;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserInfoServiceImplTest {

    private static final UserInfoDto userinfoDto = new UserInfoDto();
    @Autowired
    private UserInfoService userInfoService;

    @BeforeAll
    public static void setUp() {
        RoleDto roleDto = new RoleDto();
        PermissionDto permissionDto = new PermissionDto();
        permissionDto.setId(1L);
        permissionDto.setPermission("write");
        roleDto.setName("admin");
        roleDto.setId(1L);
        roleDto.setPermissions(Collections.singletonList(permissionDto));
        userinfoDto
                .setUsername("setUpUsername");
        userinfoDto.setPassword("qwe");
        userinfoDto.setRoles(Collections.singletonList(roleDto));
    }


    @Test
    @DisplayName("Должен искать пользователя, игнорируя регистр")
    void loadUserByUsername() {
        assertThat(userInfoService.findUserInfoByUsername("TeStUsEr").getUsername()).isEqualTo("testUser");
    }

    @Test
    @DisplayName("Создание пользователя на основе Dto")
    void shouldCreateUserInfoByUserInfoDto() {
        UserInfoDto createdUserInfoDto = userInfoService.create(userinfoDto);
        UserInfo setUpUsername = userInfoService.findUserInfoByUsername("setUpUsername");
        assertThat(createdUserInfoDto.getUsername()).isEqualTo(setUpUsername.getUsername());
        userInfoService.delete(setUpUsername);
    }

    @Test
    @DisplayName("Проверка обновления пользователя")
    void shouldUpdateUserInfoByUserInfoDto() {
        Long expectedId = userInfoService.findUserInfoByUsername(userInfoService.create(userinfoDto).getUsername()).getId();
        userinfoDto.setId(expectedId);
        userinfoDto.setUsername("UpdatedUsername");
        UserInfoDto update = userInfoService.update(userinfoDto);
        assertThat(userInfoService.findUserInfoByUsername("UpdatedUsername").getId()).isEqualTo(expectedId);
    }
}