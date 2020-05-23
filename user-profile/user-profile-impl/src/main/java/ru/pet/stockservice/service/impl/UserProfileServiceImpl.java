package ru.pet.stockservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.pet.stockservice.dto.UserProfileDto;
import ru.pet.stockservice.repository.UserProfileRepository;
import ru.pet.stockservice.service.UserProfileService;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserProfileDto findUserProfile(String username) {
        return modelMapper.map(userProfileRepository.findByUsername(username).orElseThrow(), UserProfileDto.class);
    }
}
