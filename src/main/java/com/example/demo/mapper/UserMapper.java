package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new  UserDto(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getRole()
        );
    }
    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getFirst_Name(),
                userDto.getLast_Name(),
                userDto.getEmail(),
                userDto.getRole(),
                userDto.getPassword()
        );
    }
}
