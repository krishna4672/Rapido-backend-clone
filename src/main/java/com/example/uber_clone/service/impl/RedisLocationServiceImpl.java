package com.example.uber_clone.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.connection.RedisGeoCommands.GeoLocation;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.example.uber_clone.dto.DriverLocationDto;
import com.example.uber_clone.service.LocationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RedisLocationServiceImpl implements LocationService {
    private static final String DRIVER_GEO_OPS_KEY = "driver_location:";
    private final StringRedisTemplate redisTemplate;

    @Override
    public Boolean saveDriverLocation(Long driverId, Double latitude, Double longitude){

        GeoOperations<String, String> geoOps = redisTemplate.opsForGeo();
        geoOps.add(DRIVER_GEO_OPS_KEY , new RedisGeoCommands.GeoLocation<>(driverId.toString() , new Point(longitude , latitude )));
        return true;


    }
    @Override
    public List<DriverLocationDto>getNearbyLocations(Double latitude, Double longitude, Double radiusInKm){

        GeoOperations<String, String> geoOps = redisTemplate.opsForGeo();
        Distance distance = new Distance(radiusInKm, Metrics.KILOMETERS);
        Circle circle = new Circle(new Point(longitude, latitude), distance);

        GeoResults<GeoLocation<String>> geoResults = geoOps.radius(DRIVER_GEO_OPS_KEY, circle); // query redis

       List<DriverLocationDto> diversLocations = new ArrayList<>() ;

       for(GeoResult<GeoLocation<String>> result : geoResults){

        Point point = geoOps.position(DRIVER_GEO_OPS_KEY , result.getContent().getName()).get(0) ;

        DriverLocationDto driverLocationDto = DriverLocationDto.builder()
                .driverId(Long.valueOf(result.getContent().getName()))
                .latitude(point.getX())
                .longitude(point.getY())
                .build();
        diversLocations.add(driverLocationDto);

        
       }
        return diversLocations;
    }
}
