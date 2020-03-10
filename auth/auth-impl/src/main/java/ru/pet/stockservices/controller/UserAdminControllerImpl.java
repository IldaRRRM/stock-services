package ru.pet.stockservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.pet.stockservices.dto.PermissionDto;
import ru.pet.stockservices.dto.RoleDto;
import ru.pet.stockservices.dto.UserInfoDto;
import ru.pet.stockservices.service.PermissionService;
import ru.pet.stockservices.service.RoleService;
import ru.pet.stockservices.service.UserInfoService;

import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserAdminControllerImpl implements UserAdminController {

    private final UserInfoService userInfoService;
    private final RoleService roleService;
    private final PermissionService permissionService;

    @Override
    public String showCreateUserPage(Model model) {
        UserInfoDto userInfoDto = new UserInfoDto();
        fillUserModel(model, userInfoDto);
        return "new_user";
    }

    @Override
    public String createUser(UserInfoDto userInfoDto, RoleDto roleDto, PermissionDto permissionDto) {
        UserInfoDto updatedUserDto = updateUserInfoDto(userInfoDto, roleDto, permissionDto);
        userInfoService.create(updatedUserDto);
        return "redirect:/users/";
    }

    @Override
    public String showUpdateUserPage(Long id, Model model) {
        UserInfoDto userInfoDto = userInfoService.findUserInfoById(id);
        fillUserModel(model, userInfoDto);
        return "edit";
    }

    @Override
    public String updateUser(UserInfoDto userInfoDto, RoleDto roleDto, PermissionDto permissionDto) {
        UserInfoDto infoDto = updateUserInfoDto(userInfoDto, roleDto, permissionDto);
        userInfoService.update(infoDto);
        return "redirect:/users/";
    }

    @Override
    public String findUser(Long id, Model model) {
        model.addAttribute("user", userInfoService.findUserInfoById(id));
        return "one_user";
    }

    @Override
    public String deleteUser(Long id, Model model) {
        userInfoService.delete(id);
        return "redirect:/users/";
    }

    @Override
    public String getUserList(Model model) {
        model.addAttribute("users", userInfoService.findAll());
        return "admin";
    }

    private void fillUserModel(Model model, UserInfoDto userInfoDto) {
        List<RoleDto> roles = roleService.findAll();
        List<PermissionDto> permissions = permissionService.findAll();
        RoleDto roleDto = new RoleDto();
        PermissionDto permissionDto = new PermissionDto();
        model.addAttribute("user", userInfoDto);
        model.addAttribute("roles", roles);
        model.addAttribute("permissions", permissions);
        model.addAttribute("role", roleDto);
        model.addAttribute("permission", permissionDto);
    }

    private UserInfoDto updateUserInfoDto(UserInfoDto userInfoDto, RoleDto roleDto, PermissionDto permissionDto) {
        RoleDto userRoleDto = roleService.findByName(roleDto.getName());
        PermissionDto permission = permissionService.findByPermission(permissionDto.getPermission());
        userRoleDto.setPermissions(Collections.singletonList(permission));
        userInfoDto.setRoles(Collections.singletonList(userRoleDto));
        return userInfoDto;
    }

}
