package com.example.uber_clone.service;

import java.util.List;
import java.util.Optional;

import com.example.uber_clone.dto.PassengerResponse;






public interface PassengerReadService {

    Optional<PassengerResponse>findById(Long id);
    List<PassengerResponse>findAll();
    Optional<PassengerResponse>findByEmail(String email);
}

    
