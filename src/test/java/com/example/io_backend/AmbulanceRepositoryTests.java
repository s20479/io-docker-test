package com.example.io_backend;

import com.example.io_backend.model.Ambulance;
import com.example.io_backend.model.enums.AmbulanceKind;
import com.example.io_backend.model.enums.AmbulanceType;
import com.example.io_backend.repository.AmbulanceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AmbulanceRepositoryTests {

    @Autowired
    AmbulanceRepository ambulanceRepository;

    @Test
    public void findAllByIdLessThan() {
        for(int i = 0; i < 100; i += 10) {
            for(var it : ambulanceRepository.findAllByIdLessThan(i)) {
                assertTrue(it.getId() < i, "Id greater than requested");
            }
        }
    }

    @Test
    public void findAllByAmbulanceType() {
        for(var type : AmbulanceType.values()) {
            var list = ambulanceRepository.findAllByAmbulanceType(type);
            list.removeIf(it -> it.getAmbulanceType() == type);
            assertTrue(list.isEmpty(), "Ambulance list contains other types!");
        }
    }

    @Test
    public void findAllByAmbulanceKind() {
        for(var kind : AmbulanceKind.values()) {
            var list = ambulanceRepository.findAllByAmbulanceKind(kind);
            assertFalse(list.stream().anyMatch(it -> it.getAmbulanceKind() != kind), "Ambulance list contains other kinds!");
        }
    }

    @Test
    public void findAllByFuelCapacityLessThan() {
        for(int i = 0; i < 1000000; i += 100) {
            var list = ambulanceRepository.findAllByFuelCapacityLessThan(i);
            int finalI = i;
            assertFalse(list.stream().anyMatch(it -> it.getFuelCapacity() > finalI), "Found ambulance with capacity greater than: " + i);
        }
    }

    @Test
    public void findAllByAmbulanceKindIsNotIn() {
        for(var kind : AmbulanceKind.values()) {
            var list = new LinkedList<AmbulanceKind>();
            list.add(kind);

            var fromDb = ambulanceRepository.findAllByAmbulanceKindIsNotIn(list);

            assertFalse(fromDb.stream().anyMatch(it -> it.getAmbulanceKind() == kind));
        }
    }

    @Test
    public void findAllByFuelCapacityBetweenAndAmbulanceKind() {
        Ambulance ambulance = new Ambulance();
        ambulance.setAmbulanceKind(AmbulanceKind.N);
        ambulance.setAmbulanceType(AmbulanceType.A);
        ambulance.setId(null);
        ambulance.setPeopleCapacity(5);
        ambulance.setPlates(null);
        ambulance.setFuelCapacity(1);

        ambulanceRepository.save(ambulance);

        var list = ambulanceRepository.findAllByFuelCapacityBetweenAndAmbulanceKind(1000, Integer.MAX_VALUE, ambulance.getAmbulanceKind());

        assertFalse(list.isEmpty());
        assertFalse(list.stream().anyMatch(it -> it.getAmbulanceKind() != ambulance.getAmbulanceKind()));
    }
}
