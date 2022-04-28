package com.example.io_backend.service;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.Equipment;
import com.example.io_backend.model.dto.EquipmentDto;
import com.example.io_backend.model.dto.response.EquipmentResponse;
import com.example.io_backend.repository.EquipmentRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        when(equipmentRepository.findById(any(Long.class))).thenReturn(Optional.of(new Equipment(1L, "eq1")));

        var result = equipmentService.getEquipmentById(1L);

        assertNotNull(result);
        assertEquals("eq1", result.getName());
    }

    @Test
    void getEquipmentByName() {
        var expected = new EquipmentResponse("eq1");
        when(equipmentRepository.getEquipmentByName(any(String.class))).thenReturn(List.of(new Equipment(1L, "eq1")));

        var result = equipmentService.getEquipmentByName("eq1");

        assertEquals(1, result.size());
        assertEquals(expected.getName(), result.get(0).getName());
    }

    @Test
    void addEquipment() {
        EquipmentDto dto = new EquipmentDto("eq1");

        when(equipmentRepository.save(any(Equipment.class))).thenAnswer(x -> x.getArguments()[0]);

        var result = equipmentService.addEquipment(List.of(dto));

        assertEquals(1, result.size());
        assertEquals("eq1", result.get(0).getName());
    }

    @Test
    void updateEquipment() {
        EquipmentDto dto = new EquipmentDto("eq1");
        Long id = 1L;

        var expected = new EquipmentResponse(dto.getName());

        when(equipmentRepository.findById(any(Long.class))).thenReturn(Optional.of(new Equipment(id, "eq1")));
        when(equipmentRepository.save(any(Equipment.class))).thenAnswer(x -> x.getArguments()[0]);

        var result = equipmentService.updateEquipment(dto, id);

        assertEquals(expected.getName(), result.getName());

    }

    @Test
    void deleteEquipment() {
        Equipment eq = mock(Equipment.class);
        when(equipmentRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(eq));

        equipmentService.deleteEquipment(1L);

        verify(equipmentRepository, times(1)).delete(any(Equipment.class));
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