package com.example.io_backend.service;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.Equipment;
import com.example.io_backend.model.dto.response.EquipmentResponse;
import com.example.io_backend.repository.EquipmentRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EquipmentServiceTest {
    private final EquipmentRepository equipmentRepository = mock(EquipmentRepository.class);
    private final EquipmentService equipmentService = new EquipmentService(equipmentRepository);

    @Test
    void getEquipment() {
        var equipmentList = getEquipmentTestData();
        var expected = getExpectedResponseFrom(equipmentList);

        when(equipmentRepository.findAll()).thenReturn(equipmentList);

        List<EquipmentResponse> result = equipmentService.getEquipment();

        assertNotNull(result);
        assertEquals(3, expected.size());
        assertEquals(equipmentList.get(0).getName(), result.get(0).getName());
    }

    @Test
    void getEquipmentById() {
        var expected = new EquipmentResponse("eq1");

        when(equipmentRepository.findById(any(Long.class))).thenReturn(Optional.of(new Equipment(1L, "eq1")));

        var result = equipmentService.getEquipmentById(1L);

        assertNotNull(result);
        assertEquals("eq1", result.getName());
    }

    @Test
    void getEquipmentByName() {
    }

    @Test
    void addEquipment() {
    }

    @Test
    void updateEquipment() {
    }

    @Test
    void deleteEquipment() {
    }

    private List<Equipment> getEquipmentTestData() {
        return  List.of(
                new Equipment(1L, "eq1"),
                new Equipment(2L, "eq2"),
                new Equipment(3L, "eq3")
        );
    }

    private List<EquipmentResponse> getExpectedResponseFrom(List<Equipment> equipment) {
        List<EquipmentResponse> responses = new ArrayList<>();
        equipment.forEach(x -> responses.add(new EquipmentResponse(x.getName())));

        return responses;
    }
}