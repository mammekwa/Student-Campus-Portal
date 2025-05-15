package com.example.demo.controller;

import com.example.demo.dto.BookingDto;
import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id){
        return bookingService.getBookingById(id)
                .orElseThrow(()-> new RuntimeException("Booking not found"));
    }
    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {
        BookingDto savedBooking = bookingService.createBooking(bookingDto);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking booking){
        return bookingService.updateBooking(id, booking);
    }
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id){
        bookingService.deleteBooking(id);
    }





}
