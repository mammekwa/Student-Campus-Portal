package com.example.demo.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@Getter
@Setter
public class BookingDto {
    private Long bookingId;
    private Long studentId;
    private String roomNumber;
    private LocalDate date;
    private LocalDateTime timeSlot;


    public BookingDto(Long bookingID, Long userId, String roomNumber, LocalDate date, LocalDateTime timeSlot) {
    }
}
