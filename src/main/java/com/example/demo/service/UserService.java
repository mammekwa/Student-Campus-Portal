package com.example.demo.service;

import com.example.demo.dto.UserDto;
import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updatePassword(Long userId, UserDto updatedPassword);
}
