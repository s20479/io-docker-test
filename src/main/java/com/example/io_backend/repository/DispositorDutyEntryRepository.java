package com.example.io_backend.repository;

import com.example.io_backend.model.DispositorDutyEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositorDutyEntryRepository extends JpaRepository<DispositorDutyEntry, Integer> {
}