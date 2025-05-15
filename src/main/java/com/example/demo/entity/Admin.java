package com.example.demo.entity;

import com.example.demo.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class Admin extends  User{
//      @Id
//      @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long adminId;
    public Admin(){
        super();
    }
    public Admin(Long id, String firstName, String lastName, String email, Role role, String encodedPassword) {
        super(id, firstName, lastName, email, role, encodedPassword);
    }
}
