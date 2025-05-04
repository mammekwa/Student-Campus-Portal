package com.example.demo.entity;

import com.example.demo.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        private Long userId;
        @Column(name = "first_Name")
        private String firstName;
        @Column(name="last_Name")
        private String lastName;
        @Column(name="email_Id", nullable = false, unique = true)
        private String email;
        @Column(name = "role")
        @Enumerated(EnumType.STRING)
        private Role role;
        @Column(name="password")
        private String password;
}
