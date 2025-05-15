package com.example.demo.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingDto {
    private Long studentId;
    private String roomNumber;
    private LocalDate date;
    private LocalDateTime timeSlot;


}
