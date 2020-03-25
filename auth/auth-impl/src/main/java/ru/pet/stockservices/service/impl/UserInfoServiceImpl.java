package ru.pet.stockservices.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.pet.stockservices.dto.UserInfoDto;
import ru.pet.stockservices.model.UserInfo;
import ru.pet.stockservices.repository.UserInfoRepository;
import ru.pet.stockservices.service.UserInfoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserInfoServiceImpl implements UserDetailsService, UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository, ModelMapper mapper, @Lazy PasswordEncoder passwordEncoder) {
        this.userInfoRepository = userInfoRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userInfoRepository.findUserInfoByUsernameIgnoreCase(username).orElseThrow();
    }

    @Override
    public UserInfoDto create(UserInfoDto userInfoDto) {
        userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
        UserInfo savedUser = userInfoRepository.save(mapper.map(userInfoDto, UserInfo.class));
        return mapper.map(savedUser, UserInfoDto.class);
    }

    @Override
    public UserInfoDto update(UserInfoDto userInfoDto) {
        UserInfo mappedUserInfo = mapper.map(userInfoDto, UserInfo.class);
        UserInfo userInfo = userInfoRepository.findById(userInfoDto.getId()).orElseThrow();

        userInfo.setEnabled(mappedUserInfo.isEnabled());
        userInfo.setUsername(mappedUserInfo.getUsername());
        userInfo.setRoles(mappedUserInfo.getRoles());
        userInfo.setPassword(mappedUserInfo.getPassword());

        UserInfo updatedUser = userInfoRepository.save(userInfo);
        return mapper.map(updatedUser, UserInfoDto.class);
    }

    @Override
    public void delete(Long userInfoId) {
        userInfoRepository.deleteById(userInfoId);
    }

    @Override
    public void delete(UserInfo userInfo) {
        userInfoRepository.delete(userInfo);
    }

    @Override
    public List<UserInfoDto> findAll() {
        return userInfoRepository.findAll()
                .stream()
                .map(userInfo -> mapper.map(userInfo, UserInfoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserInfoDto findUserInfoById(Long userInfoId) {
        return mapper.map(userInfoRepository.findById(userInfoId).orElseThrow(), UserInfoDto.class);
    }

    @Override
    public UserInfo findUserInfoByUsername(String username) {
        return userInfoRepository.findUserInfoByUsernameIgnoreCase(username).orElseThrow();
    }
}
