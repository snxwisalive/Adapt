package com.diploma.adapt.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.diploma.adapt.dto.UserProfileDTO;
import com.diploma.adapt.mapper.UserMapper;
import com.diploma.adapt.model.User;
import com.diploma.adapt.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserProfileDTO getUserProfile(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new NoSuchElementException("User not found"));

        return userMapper.toProfileDTO(user);
    }
}