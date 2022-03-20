package com.example.io_backend.repository;

import com.example.io_backend.model.AmbulanceAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmbulanceAvailabilityRepository extends JpaRepository<AmbulanceAvailability, Long> {
}