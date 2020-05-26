package ru.pet.stockservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.pet.stockservice.dto.UserProfileDto;
import ru.pet.stockservice.model.UserPreference;
import ru.pet.stockservice.model.UserProfile;
import ru.pet.stockservice.repository.UserProfileRepository;
import ru.pet.stockservice.service.UserProfileService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserProfileDto findUserProfile(String username) {
        return modelMapper.map(userProfileRepository.findByUsername(username).orElseThrow(), UserProfileDto.class);
    }

    @Override
    public UserProfileDto fillUserProfile(String username) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(username);
        userProfile.setBalance(0.0);
        return modelMapper.map(userProfileRepository.save(userProfile), UserProfileDto.class);
    }

    @Override
    public UserProfileDto fillUserProfile(UserProfileDto userProfileDto) {
        UserProfile updatedUser = userProfileRepository.findByUsername(userProfileDto.getUsername()).orElseThrow();
        updatedUser.setAge(userProfileDto.getAge());
        List<UserPreference> userPreferences = userProfileDto
                .getUserPreferences()
                .stream()
                .map(userPreferenceDto -> modelMapper.map(userPreferenceDto, UserPreference.class))
                .collect(Collectors.toList());
        updatedUser.setUserPreferences(userPreferences);
        updatedUser.setPurchaseBudget(userProfileDto.getPurchaseBudget());
        UserProfile savedUser = userProfileRepository.save(updatedUser);
        return modelMapper.map(savedUser, UserProfileDto.class);
    }
}