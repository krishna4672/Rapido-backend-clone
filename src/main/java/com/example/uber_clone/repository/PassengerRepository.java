package com.example.uber_clone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.uber_clone.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    
    Optional<Passenger> findByEmail(String email);
    boolean existsByEmail(String email);
}
