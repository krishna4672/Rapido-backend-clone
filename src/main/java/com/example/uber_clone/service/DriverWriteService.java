package com.example.uber_clone.service;


import java.math.BigDecimal;

import com.example.uber_clone.dto.DriverRequest;
import com.example.uber_clone.dto.DriverResponse;


public interface DriverWriteService {
    DriverResponse create(DriverRequest request);
    DriverResponse update(Long id, DriverRequest request);
    void deleteById(Long id);

}
