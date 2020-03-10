package ru.pet.stockservices.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(of = {"id", "username"})
public class UserInfoDto {

    private Long id;

    private String username;

    private String password;

    private boolean enabled = true;

    private boolean accountNonExpired = true;

    private boolean credentialsNonExpired = true;

    private boolean accountNonLocked = true;

    private LocalDateTime lastLogin;

    private List<RoleDto> roles = new ArrayList<>();

}
