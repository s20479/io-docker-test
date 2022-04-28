package com.example.io_backend.model.dto;

import com.example.io_backend.model.enums.AvailabilityType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AmbulanceAvailabilityDto {
    AvailabilityType availabilityType;
    LocalDate since;
    LocalDate to;
    String details;
}
