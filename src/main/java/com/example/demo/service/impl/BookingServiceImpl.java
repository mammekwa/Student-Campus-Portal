package com.example.demo.service.impl;

import com.example.demo.dto.BookingDto;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Student;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.BookingMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;
    private StudentRepository studentRepository;


    public BookingServiceImpl(BookingRepository bookingRepository, StudentRepository studentRepository) {
        this.bookingRepository = bookingRepository;
        this.studentRepository = studentRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        Student student = studentRepository.findById(bookingDto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Booking booking = BookingMapper.mapToBooking(bookingDto, student);

        Booking saved = bookingRepository.save(booking);
        return BookingMapper.mapToBookingDto(saved);

    }



    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public Booking updateBooking(Long id, Booking bookingDetails) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setRoomNumber(bookingDetails.getRoomNumber());
            booking.setDate(bookingDetails.getDate());
            booking.setTimeSlot(bookingDetails.getTimeSlot());
            booking.setStudent(bookingDetails.getStudent());
            return bookingRepository.save(booking);
        }).orElseThrow(() -> new RuntimeException("Booking not found"));
    }
}
