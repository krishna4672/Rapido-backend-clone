package com.example.uber_clone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.uber_clone.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    
    Optional<Driver>findByEmail(String email);
    Optional<Driver>findByLicenseNumber(String licenseNumber);
    boolean existsByEmail(String email);
    boolean existsByLicenseNumber(String licenseNumber);
}
