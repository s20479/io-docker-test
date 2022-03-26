package com.example.io_backend.controller;

import com.example.io_backend.model.Ambulance;
import com.example.io_backend.service.AmbulanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/ambulance")
public class AmbulanceController {

    private final AmbulanceService ambulanceService;

    @GetMapping("")
    public List<Ambulance> getAll() {
        return ambulanceService.getAmbulances();
    }

    @GetMapping("{id}")
    public Ambulance getById(@PathVariable Integer id) {
        return ambulanceService.getAmbulanceById(id);
    }

    @PostMapping("")
    public Ambulance add(@RequestBody Ambulance ambulance) {
        return ambulanceService.addAmbulance(ambulance);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Ambulance ambulance,@PathVariable Integer id){
        ambulanceService.updateAmbulance(ambulance, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        ambulanceService.deleteAmbulance(id);
    }

}
