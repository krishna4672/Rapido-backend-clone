package com.example.uber_clone.service.impl;

import com.example.uber_clone.mapper.BookingMapper;
import com.example.uber_clone.repository.BookingRepository;
import com.example.uber_clone.repository.DriverRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.uber_clone.dto.BookingResponse;
import com.example.uber_clone.dto.PassengerRequest;
import com.example.uber_clone.dto.PassengerResponse;
import com.example.uber_clone.entity.Passenger;
import com.example.uber_clone.repository.PassengerRepository;
import com.example.uber_clone.service.PassengerService;
import com.example.uber_clone.mapper.PassengerMapper;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional
public class PassengerServiceImpl implements PassengerService {
    
    
    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;


   

   
    @Override
    @Transactional(readOnly = true)
    public Optional<PassengerResponse>findById(Long id) {
        return passengerRepository.findById(id)
                .map(passengerMapper::toResponse);
    }


    @Override
    @Transactional(readOnly = true)
    public List<PassengerResponse> findAll() {
        return passengerRepository.findAll().stream()
                .map(passengerMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PassengerResponse>findByEmail(String email){
        return passengerRepository.findByEmail(email)
                .map(passengerMapper::toResponse);
    }

    @Override
    public PassengerResponse create(PassengerRequest request){

        if(passengerRepository.existsByEmail(request.getEmail())){
            throw new IllegalArgumentException("Passenger with email " + request.getEmail() + " already exists.");
        }

        Passenger passenger = passengerMapper.toEntity(request);
        Passenger savedPassenger = passengerRepository.save(passenger);
        return passengerMapper.toResponse(savedPassenger);
    }


    @Override
    public PassengerResponse update(Long id, PassengerRequest request){

        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Passenger with id " + id + " not found."));

        if(!passenger.getEmail().equals(request.getEmail()) && passengerRepository.existsByEmail(request.getEmail())){
            throw new IllegalArgumentException("Passenger with email " + request.getEmail() + " already exists.");
        }

        passengerMapper.updateEntity(passenger, request);
        Passenger updatedPassenger = passengerRepository.save(passenger);
        return passengerMapper.toResponse(updatedPassenger);
    }

    @Override
    public void deletePassenger(Long id){
        if(passengerRepository.existsById(id)){
            throw new IllegalStateException("Cannot delete passenger with id " + id + " because they have associated drivers.");
        }
        passengerRepository.deleteById(id);
    }

}
