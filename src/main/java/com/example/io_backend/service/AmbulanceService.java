package com.example.io_backend.service;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.Ambulance;
import com.example.io_backend.repository.AmbulanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AmbulanceService {
    private final AmbulanceRepository ambulanceRepository;

    public List<Ambulance> getAmbulances(){
        return ambulanceRepository.findAll();
    }

    public Ambulance getAmbulanceById(Integer id){
        return ambulanceRepository.findById(id).orElseThrow(()-> new NotFoundException("No record with that ID"));
    }

    public Ambulance addAmbulance(Ambulance ambulance){
        return ambulanceRepository.save(ambulance);
    }

    public void updateAmbulance(Ambulance ambulance, Integer id) {
        var a = ambulanceRepository.findById(id).orElseThrow(()-> new NotFoundException("No record with that ID"));

        a.setId(ambulance.getId());
        a.setAmbulanceKind(ambulance.getAmbulanceKind());
        a.setAmbulanceType(ambulance.getAmbulanceType());
        a.setFuelCapacity(ambulance.getFuelCapacity());
        a.setPlates(ambulance.getPlates());
        a.setPeopleCapacity(ambulance.getPeopleCapacity());
        ambulanceRepository.save(a);
    }

    public void deleteAmbulance(Integer id) {
        var a = ambulanceRepository.findById(id).orElseThrow(()-> new NotFoundException("No record with that ID"));

        ambulanceRepository.delete(a);
    }
}
