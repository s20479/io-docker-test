package com.example.io_backend.repository;

import com.example.io_backend.model.AmbulanceAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AmbulanceAvailabilityRepository extends JpaRepository<AmbulanceAvailability, Long> {
    Optional<AmbulanceAvailability> findByAmbulanceId(Integer id);
}