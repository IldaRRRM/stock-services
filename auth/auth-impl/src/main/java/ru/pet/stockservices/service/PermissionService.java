package ru.pet.stockservices.service;

import ru.pet.stockservices.dto.PermissionDto;

import java.util.List;

public interface PermissionService {

    List<PermissionDto> findAll();

    PermissionDto findPermissionById(Long id);

    PermissionDto findByPermission(String permission);

}
