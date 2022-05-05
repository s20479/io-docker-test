package com.example.io_backend.repository;

import com.example.io_backend.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Staff getById(String id);
}