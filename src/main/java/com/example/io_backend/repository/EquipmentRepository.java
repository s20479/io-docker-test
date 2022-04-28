package com.example.io_backend.repository;

import com.example.io_backend.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    Optional<Equipment> findById(Long id);

    List<Equipment> getEquipmentByName(String name);
}