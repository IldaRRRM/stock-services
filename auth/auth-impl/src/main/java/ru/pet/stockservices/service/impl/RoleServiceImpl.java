package ru.pet.stockservices.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.pet.stockservices.dto.RoleDto;
import ru.pet.stockservices.repository.RoleRepository;
import ru.pet.stockservices.service.RoleService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<RoleDto> findAll() {
        return roleRepository.findAll().stream()
                .map(role -> modelMapper.map(role, RoleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto findById(Long id) {
        return modelMapper.map(roleRepository.findById(id).orElseThrow(), RoleDto.class);
    }

    @Override
    public RoleDto findByName(String roleName) {
        return modelMapper.map(roleRepository.findRoleByNameIgnoreCase(roleName).orElseThrow(), RoleDto.class);
    }
}
