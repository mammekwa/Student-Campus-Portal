package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class Admin extends  User{
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long adminId;
}
