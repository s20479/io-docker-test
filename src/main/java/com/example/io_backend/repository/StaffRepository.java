package com.example.io_backend.repository;

import com.example.io_backend.model.Staff;
import com.example.io_backend.model.enums.StaffType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Staff getById(String id);
    List<Staff> getAllByStaffType(StaffType staffType);
}
