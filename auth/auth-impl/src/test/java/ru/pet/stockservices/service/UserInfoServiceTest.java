package ru.pet.stockservices.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


@SpringBootTest
class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    @WithMockUser(username = "testUser", authorities = ("read"), password = "qwe")
    void shouldThrowAccessDeniedException() {

        Throwable throwable = catchThrowable(() -> userInfoService.delete(1L));

        assertThat(throwable)
                .isInstanceOf(AccessDeniedException.class);
    }

    @Test
    @WithMockUser(username = "testUser", authorities = "write", password = "qwe")
    void shouldDeleteUserWitThosePermissions() {
        userInfoService.delete(1L);
    }

}