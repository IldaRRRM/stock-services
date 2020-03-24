package ru.pet.stockservices.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.pet.stockservices.dto.PermissionDto;
import ru.pet.stockservices.repository.PermissionRepository;
import ru.pet.stockservices.service.PermissionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<PermissionDto> findAll() {
        return repository.findAll()
                .stream()
                .map(permission -> modelMapper.map(permission, PermissionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PermissionDto findPermissionById(Long id) {
        return modelMapper.map(repository.findById(id).orElseThrow(), PermissionDto.class);
    }

    @Override
    public PermissionDto findByPermission(String permission) {
        return modelMapper.map(repository.findByPermissionIgnoreCase(permission).orElseThrow(), PermissionDto.class);
    }
}
