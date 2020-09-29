package ru.pet.stockservices.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
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

    @Autowired
    private UserDetailsService userDetails;

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
    @WithMockUser(username = "testUser", authorities = ("write"), password = "qwe")
    @DisplayName("Должен искать пользователя, игнорируя регистр")
    void loadUserByUsername() {
        assertThat(userDetails.loadUserByUsername("TeStUsEr").getUsername()).isEqualTo("testUser");
    }

    @Test
    @WithMockUser(username = "testUser", authorities = ("write"), password = "qwe")
    @DisplayName("Создание пользователя на основе Dto")
    void shouldCreateUserInfoByUserInfoDto() {
        UserInfoDto createdUserInfoDto = userInfoService.create(userinfoDto);
        UserInfo setUpUsername = (UserInfo) userDetails.loadUserByUsername("setUpUsername");
        assertThat(createdUserInfoDto.getUsername()).isEqualTo(setUpUsername.getUsername());
        userInfoService.delete(setUpUsername);
    }

    @Test
    @DisplayName("Проверка обновления пользователя")
    @WithMockUser(username = "testUser", authorities = ("write"), password = "qwe")
    void shouldUpdateUserInfoByUserInfoDto() {
        UserInfo userInfo = (UserInfo) userDetails.loadUserByUsername(userInfoService.create(userinfoDto).getUsername());
        Long expectedId = userInfo.getId();
        userinfoDto.setId(expectedId);
        userinfoDto.setUsername("UpdatedUsername");
        UserInfoDto update = userInfoService.update(userinfoDto);
        assertThat(userInfoService.findUserInfoByUsername("UpdatedUsername").getId()).isEqualTo(expectedId);
    }
}