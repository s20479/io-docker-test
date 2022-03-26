package com.example.io_backend.controller;

import com.example.io_backend.model.AmbulanceAvailability;
import com.example.io_backend.service.AmbulanceAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ambulanceAvailability")
@RequiredArgsConstructor
public class AmbulanceAvailabilityController {
    private final AmbulanceAvailabilityService ambulanceAvailabilityService;

    @GetMapping("")
    public List<AmbulanceAvailability> getAll() {
        return ambulanceAvailabilityService.getAmbulanceAvailabilities();
    }

    @GetMapping("{id}")
    public AmbulanceAvailability getById(@PathVariable Long id) {
        return ambulanceAvailabilityService.getAmbulanceAvailabilityById(id);
    }

    @PostMapping("")
    public AmbulanceAvailability add(@RequestBody AmbulanceAvailability ambulanceAvailability) {
        return ambulanceAvailabilityService.addAmbulanceAvailibility(ambulanceAvailability);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody AmbulanceAvailability ambulanceAvailability,@PathVariable Long id){
        ambulanceAvailabilityService.updateAmbulanceAvailibility(ambulanceAvailability, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ambulanceAvailabilityService.deleteAmbulanceAvailibility(id);
    }

}
