package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student extends User{

    private long studentId;

    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
    List<Booking> booking;
}
