package com.example.io_backend.repository;

import com.example.io_backend.model.Staff;
import com.example.io_backend.model.enums.StaffType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Staff getById(Integer id);
    Staff getByUser_Id(String userId);
    List<Staff> getAllByStaffType(StaffType type);
}

