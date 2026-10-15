package com.example.uber_clone.service;

import java.util.List;
import java.util.Optional;

import com.example.uber_clone.dto.BookingResponse;

public interface BookingReadService {
    Optional<BookingResponse> findById(Long id);
    List<BookingResponse> findAll();
    List<BookingResponse> findByPassengerId(Long passengerId);
    List<BookingResponse> findByDriverId(Long driverId);
}
