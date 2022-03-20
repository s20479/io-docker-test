package com.example.io_backend.repository;

import com.example.io_backend.model.AccidentReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentReportRepository extends JpaRepository<AccidentReport, Long> {
}