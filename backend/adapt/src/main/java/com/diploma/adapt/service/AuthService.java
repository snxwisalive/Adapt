package com.diploma.adapt.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.diploma.adapt.model.User;
import com.diploma.adapt.dto.AuthResponseDTO;
import com.diploma.adapt.dto.UserLoginDTO;
import com.diploma.adapt.dto.UserRegistrationDTO;
import com.diploma.adapt.repository.UserRepository;
import com.diploma.adapt.mapper.UserMapper;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.jwtService = jwtService;
    }

    public AuthResponseDTO registerUser(UserRegistrationDTO dto) {
        String user = dto.getUsername();

        if (userRepository.existsByUsername(user)) {
            throw new IllegalArgumentException("User with this name already exists");
        }

        String rawPassword = dto.getPassword();
        String hashedPassword = passwordEncoder.encode(rawPassword);

        User newUser = userMapper.toEntity(dto);
        newUser.setPassword(hashedPassword);

        User saved = userRepository.save(newUser);

        String token = jwtService.generateToken(saved.getUsername());

        return AuthResponseDTO.builder()
                .id(saved.getId())
                .token(token)
                .username(saved.getUsername())
                .build();
    }

    public AuthResponseDTO login(UserLoginDTO dto) {
        User user = userRepository.findByUsername(dto.getUsername()).orElseThrow(() -> new IllegalArgumentException("Wrong login or password"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Wrong login or password");
        }

        String token = jwtService.generateToken(user.getUsername());

        return AuthResponseDTO.builder()
                .id(user.getId())
                .token(token)
                .username(user.getUsername())
                .build();
    }
}