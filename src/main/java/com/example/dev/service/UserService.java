package com.example.dev.service;

import com.example.dev.dto.*;
import java.util.List;

public interface UserService {
    UserDto createUser(CreateUserDto dto);
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    UserDto updateUser(Long id, CreateUserDto dto);
    void deleteUser(Long id);
}
