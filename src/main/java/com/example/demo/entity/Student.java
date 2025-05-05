package com.example.demo.entity;

import jakarta.persistence.Id;

public class Student extends User{
    @Id
    private long studentId;
}
