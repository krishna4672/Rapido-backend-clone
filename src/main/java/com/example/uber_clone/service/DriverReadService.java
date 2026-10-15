package com.example.uber_clone.service;

import java.util.List;
import java.util.Optional;

import com.example.uber_clone.dto.DriverResponse;

public interface DriverReadService {

    Optional<DriverResponse> findById(Long id);
    List<DriverResponse> findAll();
    Optional<DriverResponse> findByEmail(String email);
    List<DriverResponse> findAvailableDrivers();
} 