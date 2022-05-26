package com.example.io_backend.repository;

import com.example.io_backend.model.DispositorDutyEntry;
import com.example.io_backend.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositorDutyEntryRepository extends JpaRepository<DispositorDutyEntry, Integer> {

    DispositorDutyEntry getFirstByDutyEndIsNotNullAndStaffEquals(Staff staff);
}
