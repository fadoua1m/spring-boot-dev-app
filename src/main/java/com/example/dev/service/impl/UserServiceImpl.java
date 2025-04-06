package com.example.dev.service.impl;

import com.example.dev.dto.*;
import com.example.dev.model.*;
import com.example.dev.repository.*;
import com.example.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(CreateUserDto dto) {
        User user = new User();
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPwd(passwordEncoder.encode(dto.getPwd()));
        user.setDateEmbauche(dto.getDateEmbauche());
        user.setEtablissementOrigine(dto.getEtablissementOrigine());
        user.setDernierDiplome(dto.getDernierDiplome());
        user.setGrade(dto.getGrade());
        user.setRole(Role.valueOf(dto.getRole()));
        
        User savedUser = userRepository.save(user);
        return mapToDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToDto(user);
    }

    @Override
    public UserDto updateUser(Long id, CreateUserDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        if (dto.getPwd() != null && !dto.getPwd().isEmpty()) {
            user.setPwd(passwordEncoder.encode(dto.getPwd()));
        }
        user.setDateEmbauche(dto.getDateEmbauche());
        user.setEtablissementOrigine(dto.getEtablissementOrigine());
        user.setDernierDiplome(dto.getDernierDiplome());
        user.setGrade(dto.getGrade());
        user.setRole(Role.valueOf(dto.getRole()));
        
        User updatedUser = userRepository.save(user);
        return mapToDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserDto mapToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setDateEmbauche(user.getDateEmbauche());
        dto.setEtablissementOrigine(user.getEtablissementOrigine());
        dto.setDernierDiplome(user.getDernierDiplome());
        dto.setGrade(user.getGrade());
        dto.setRole(user.getRole().name());
        return dto;
    }
}