package com.example.io_backend.controller;

import com.example.io_backend.model.Equipment;
import com.example.io_backend.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping("")
    public List<Equipment> getAll() {
        return equipmentService.getEquipment();
    }

    @GetMapping("/{id}")
    public Equipment getById(@PathVariable Long id){
        return equipmentService.getEquipmentById(id);
    }

    @PostMapping("")
    public Equipment add(@RequestBody Equipment equipment) {
        return equipmentService.addEquipment(equipment);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Equipment equipment,@PathVariable Long id){
        equipmentService.updateEquipment(equipment,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

    }
}
