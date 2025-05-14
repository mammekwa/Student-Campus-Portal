package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    //Build Add User REST API
    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    //Build get User by their ID REST API
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userID){
        UserDto userDto = userService.getUserById(userID);
        return ResponseEntity.ok(userDto);
    }
    //Get all Users REST API
    @GetMapping
    public List<User> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        List<User> users2 = users.stream()
                .map(UserMapper::mapToUser)
                .collect(Collectors.toList());
        return users2;
    }
    //Update password REST API
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updatePassword(@PathVariable("id") Long userId, @RequestBody UserDto password){
        UserDto userDto = userService.updatePassword(userId,password);
        return ResponseEntity.ok(userDto);
    }
}
