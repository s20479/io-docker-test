package com.example.io_backend.repository;

import com.example.io_backend.model.Ambulance;
import com.example.io_backend.model.enums.AmbulanceKind;
import com.example.io_backend.model.enums.AmbulanceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AmbulanceRepository extends JpaRepository<Ambulance, Integer> {

    List<Ambulance> getAllByIdLessThan(int id);

    List<Ambulance> getAllByAmbulanceType(AmbulanceType ambulanceType);

    List<Ambulance> getAllByAmbulanceKind(AmbulanceKind ambulanceKind);

    List<Ambulance> getAllByFuelCapacityLessThan(int fuelCapacity);

    List<Ambulance> getAllByAmbulanceKindIsNotIn(Collection<AmbulanceKind> collection);

    List<Ambulance> getAllByFuelCapacityBetweenAndAmbulanceKind(int fuelCapacityLower, int fuelCapacityUpper, AmbulanceKind ambulanceKind);

    List<Ambulance> getAllByPeopleCapacity(Integer numberOfSeats);

    Optional<Ambulance> findAmbulanceByPlates(String licensePlate);

    Optional<Ambulance> findById(Integer id);
}
