package com.example.demo.mapper;

import com.example.demo.dto.BookingDto;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Student;

public class BookingMapper {
    public static BookingDto mapToBookingDto(Booking booking){
        return new  BookingDto(
                booking.getStudent().getUserId(),
                booking.getRoomNumber(),
                booking.getDate(),
                booking.getTimeSlot()
        );
    }
    public static Booking mapToBooking(BookingDto bookingDto, Student student) {
        return new Booking(
                student,
                bookingDto.getRoomNumber(),
                bookingDto.getDate(),
                bookingDto.getTimeSlot()
        );
    }
}
