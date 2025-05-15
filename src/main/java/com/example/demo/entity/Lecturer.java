package com.example.demo.entity;

import com.example.demo.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Table(name = "lecturers")
public class Lecturer extends User{
    private Long lecturerId;
    public Lecturer(){
        super();
    }
    public Lecturer(Long id, String firstName, String lastName, String email, Role role, String encodedPassword) {
        super(id, firstName, lastName, email, role, encodedPassword);
    }
}
