package com.example.demo.service;

import com.example.demo.dto.BookingDto;
import com.example.demo.entity.Booking;
import com.example.demo.service.impl.BookingServiceImpl;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    public List<Booking> getAllBookings();
    public Optional<Booking> getBookingById(Long id);
    public BookingDto createBooking(BookingDto bookingDto);

    public void deleteBooking(Long id);
    public Booking updateBooking(Long id, Booking bookingDetails);
}
