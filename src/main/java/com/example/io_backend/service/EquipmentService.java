package com.example.io_backend.service;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.Equipment;
import com.example.io_backend.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public List<Equipment> getEquipment() {
        return equipmentRepository.findAll();
    }

    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new NotFoundException(" No record with that ID"));
    }

    public Equipment addEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public void updateEquipment(Equipment equipment,Long id){
        var e = equipmentRepository.findById(id).orElseThrow(() -> new NotFoundException(" No record with that ID"));

        e.setId(equipment.getId());
        e.setName(equipment.getName());

        equipmentRepository.save(e);

    }

    public void deleteEquipment(Long id) {
        var e = equipmentRepository.findById(id).orElseThrow(() -> new NotFoundException(" No record with that ID"));
        equipmentRepository.delete(e);
    }
}
