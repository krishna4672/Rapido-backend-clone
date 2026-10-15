package com.example.uber_clone.service;

import java.util.List;

import com.example.uber_clone.dto.DriverLocationDto;

public interface LocationService {
    
    Boolean saveDriverLocation(Long driverId, Double latitude, Double longitude);
    List<DriverLocationDto>getNearbyLocations(Double latitude, Double longitude, Double radiusInKm);
}
