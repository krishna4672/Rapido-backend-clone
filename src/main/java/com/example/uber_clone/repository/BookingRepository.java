package com.example.uber_clone.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.uber_clone.entity.Booking;
import com.example.uber_clone.entity.Driver;

@ResponseBody
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
    List<Booking>findByPassengerId(Long passengerId);
    List<Driver>findByDriverId(Long driverId);
    Optional<Booking> findByIdAndPassengerId(Long id, Long passenger);
    Optional<Booking> findByIdAndDriver(Long id, Long driver);
}
