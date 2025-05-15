package com.example.demo.dto;
import com.example.demo.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String first_Name;
    private String last_Name;
    private String email;
    private String password;
    private Role role;

    public UserDto(Long userId, String firstName, String lastName, String email, Role role) {
        this.id = userId;
        this.first_Name = firstName;
        this.last_Name = lastName;
        this.email = email;
        this.role = role;
    }
}
