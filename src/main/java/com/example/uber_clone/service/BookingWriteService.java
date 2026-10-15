package com.example.uber_clone.service;

import com.example.uber_clone.dto.BookingRequest;
import com.example.uber_clone.dto.BookingResponse;
import com.example.uber_clone.entity.Booking;

public interface BookingWriteService {
    BookingResponse create(BookingRequest request);
    BookingResponse update(Long id, BookingRequest request);
    BookingResponse updateStatus(Long id, Booking.BookingStatus status);
    Boolean acceptRide(Long id, Integer driverId);
    void deleteById(Long id);
}
