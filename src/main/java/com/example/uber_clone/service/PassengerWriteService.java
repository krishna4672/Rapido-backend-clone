package com.example.uber_clone.service;

import org.springframework.stereotype.Service;

import com.example.uber_clone.dto.PassengerRequest;
import com.example.uber_clone.dto.PassengerResponse;

@Service
public interface PassengerWriteService {
    
    PassengerResponse create(PassengerRequest request);
    PassengerResponse update(Long id, PassengerRequest request);
    void deletePassenger(Long id);
}
