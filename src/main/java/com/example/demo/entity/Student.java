package com.example.demo.entity;

import com.example.demo.Role;
import com.example.demo.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "students")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User{

    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
    List<Booking> booking;

    public Student(){
        super();
    }


    public Student(Long id, String firstName, String lastName, String email, Role role, String encodedPassword) {
        super(id, firstName, lastName, email, role, encodedPassword);
    }
}
