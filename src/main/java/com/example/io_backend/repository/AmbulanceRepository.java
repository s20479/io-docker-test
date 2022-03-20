package com.example.io_backend.repository;

import com.example.io_backend.model.Ambulance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmbulanceRepository extends JpaRepository<Ambulance, Integer> {
}