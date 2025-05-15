package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Lecturer;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.LecturerRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private final StudentRepository studentRepository;
    private final LecturerRepository lecturerRepository;
    private final AdminRepository adminRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

            // Log incoming DTO
            System.out.println("Received UserDto: " + userDto);
            System.out.println("Email from DTO: " + userDto.getEmail());

            if (userDto.getEmail() == null || userDto.getEmail().isEmpty()) {
                throw new IllegalArgumentException("Email must not be null or empty.");
            }

            // Encode password
            String encodedPassword = passwordEncoder.encode(userDto.getPassword());
            User user;

            switch (userDto.getRole()) {
                case STUDENT:
                    user = new Student(
                            userDto.getId(),
                            userDto.getFirst_Name(),
                            userDto.getLast_Name(),
                            userDto.getEmail(),
                            userDto.getRole(),
                            encodedPassword
                    );
                    user = studentRepository.save((Student) user);
                    break;

                case LECTURER:
                    user = new Lecturer(
                            userDto.getId(),
                            userDto.getFirst_Name(),
                            userDto.getLast_Name(),
                            userDto.getEmail(),
                            userDto.getRole(),
                            encodedPassword
                    );
                    user = lecturerRepository.save((Lecturer) user);
                    break;

                case ADMIN:
                    user = new Admin(
                            userDto.getId(),
                            userDto.getFirst_Name(),
                            userDto.getLast_Name(),
                            userDto.getEmail(),
                            userDto.getRole(),
                            encodedPassword
                    );
                    user = adminRepository.save((Admin) user);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid role: " + userDto.getRole());
            }

            // Optional: log saved user info
            System.out.println("User saved: " + user.getEmail());

            return UserMapper.mapToUserDto(user);


    }

    @Override
        public UserDto getUserById(Long userId) {
            User user = userRepository.findById(userId)
                    .orElseThrow(()-> new ResourceNotFoundException("User number: "+ userId + " does not exist"));
            return UserMapper.mapToUserDto(user);
        }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> Users = userRepository.findAll();
        return Users.stream().map((User)->UserMapper.mapToUserDto(User))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updatePassword(Long userId, UserDto updatedPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User number: "+ userId + " does not exist"));
        user.setPassword(passwordEncoder.encode(updatedPassword.getPassword()));
        userRepository.save(user);
        return UserMapper.mapToUserDto(user);
    }
    @Override
    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

}




