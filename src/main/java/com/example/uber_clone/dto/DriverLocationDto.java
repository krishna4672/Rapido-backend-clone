package com.example.uber_clone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class DriverLocationDto {
    
    private Long driverId;
    private Double latitude;
    private Double longitude;

   

   
}
