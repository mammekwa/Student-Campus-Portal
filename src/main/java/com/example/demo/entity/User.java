package com.example.demo.entity;

import com.example.demo.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usersBase")
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long userId;
        private String firstName;
        private String lastName;
        @Column(name="email_adress", nullable = false, unique = true)
        private String email;
        @Enumerated(EnumType.STRING)
        private Role role;
        private String password;
}
