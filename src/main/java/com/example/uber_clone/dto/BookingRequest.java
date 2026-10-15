package com.example.uber_clone.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingRequest {
    
     @NotNull(message = "Passenger ID is required")
    private Long passengerId;
    
    private Long driverId;
    
    @NotNull(message = "Pickup location lat is required")
    private Double pickupLocationLatitude;

    @NotNull(message = "Pickup location long is required")
    private Double pickupLocationLongitude;
    
    private String dropoffLocation;
    
    private BigDecimal fare;
    
    private LocalDateTime scheduledPickupTime;
}
