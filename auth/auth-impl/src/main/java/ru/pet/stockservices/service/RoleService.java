package ru.pet.stockservices.service;

import ru.pet.stockservices.dto.RoleDto;

import java.util.List;

public interface RoleService {

    List<RoleDto> findAll();

    RoleDto findById(Long id);

    RoleDto findByName(String roleName);

}
