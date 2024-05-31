package com.vitulc.oauthmng.app.services;

import com.vitulc.oauthmng.app.dtos.UserDto;
import com.vitulc.oauthmng.app.entities.Users;
import com.vitulc.oauthmng.app.errors.exceptions.BadRequestException;
import com.vitulc.oauthmng.app.errors.exceptions.ConflictException;
import com.vitulc.oauthmng.app.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<String> register(UserDto userDto) {

        if (userRepository.existsByUsername(userDto.username())) {
            throw new ConflictException("Username already used");
        }

        if (userRepository.existsByEmail(userDto.email())) {
            throw new ConflictException("Email already used");
        }

        if (!userDto.password().equals(userDto.confirmPassword())) {
            throw new BadRequestException("Password and confirmation do not match");
        }

        var encryptedPassword = passwordEncoder.encode(userDto.password());
        var user = new Users(userDto, encryptedPassword);
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }
}

