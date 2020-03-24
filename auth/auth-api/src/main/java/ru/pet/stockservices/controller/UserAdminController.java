package ru.pet.stockservices.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pet.stockservices.dto.PermissionDto;
import ru.pet.stockservices.dto.RoleDto;
import ru.pet.stockservices.dto.UserInfoDto;

@RequestMapping(path = "/users/")
public interface UserAdminController {

    @GetMapping("new")
    String showCreateUserPage(Model model);

    @PostMapping(value = "create")
    String createUser(@ModelAttribute("user") UserInfoDto userInfoDto, @ModelAttribute("role") RoleDto roleDto, @ModelAttribute("permission") PermissionDto permissionDto);

    @GetMapping(value = "{id}")
    String findUser(@PathVariable("id") Long id, Model model);

    @GetMapping(value = "edit/{id}")
    String showUpdateUserPage(@PathVariable("id") Long id, Model model);

    @PostMapping(value = "update")
    String updateUser(@ModelAttribute("user") UserInfoDto userInfoDto, @ModelAttribute("role") RoleDto roleDto, @ModelAttribute("permission") PermissionDto permissionDto);

    @GetMapping(value = "delete/{id}")
    String deleteUser(@PathVariable("id") Long id, Model model);

    @GetMapping
    String getUserList(Model model);

}
