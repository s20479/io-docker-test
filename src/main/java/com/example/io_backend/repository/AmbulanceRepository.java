package com.example.io_backend.repository;

import com.example.io_backend.model.Ambulance;
import com.example.io_backend.model.enums.AmbulanceKind;
import com.example.io_backend.model.enums.AmbulanceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AmbulanceRepository extends JpaRepository<Ambulance, Integer> {

    List<Ambulance> findAllByIdLessThan(int id);

    List<Ambulance> findAllByAmbulanceType(AmbulanceType ambulanceType);

    List<Ambulance> findAllByAmbulanceKind(AmbulanceKind ambulanceKind);

    List<Ambulance> findAllByFuelCapacityLessThan(int fuelCapacity);

    List<Ambulance> findAllByAmbulanceKindIsNotIn(Collection<AmbulanceKind> collection);

    List<Ambulance> findAllByFuelCapacityBetweenAndAmbulanceKind(int fuelCapacityLower, int fuelCapacityUpper, AmbulanceKind ambulanceKind);
}
