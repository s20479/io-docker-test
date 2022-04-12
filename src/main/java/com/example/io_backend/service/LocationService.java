package com.example.io_backend.service;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.Location;
import com.example.io_backend.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(Long id){
        return locationRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with that ID"));
    }

    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    public void updateLocation(Location location,Long id) {
        var l = locationRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with that ID"));
        l.setId(location.getId());
        l.setLatitude(location.getLatitude());
        l.setLongitude(location.getLongitude());

        locationRepository.save(l);
    }

    public void deleteLocation(Long id) {
        var l = locationRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with that ID"));
        locationRepository.delete(l);
    }
}
