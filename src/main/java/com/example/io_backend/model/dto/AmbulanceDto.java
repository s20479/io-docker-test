package com.example.io_backend.model.dto;

import com.example.io_backend.model.AmbulanceAvailability;
import com.example.io_backend.model.enums.AmbulanceKind;
import com.example.io_backend.model.enums.AmbulanceType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AmbulanceDto {
    private Integer numberOfSeats;
    private Integer fuelTankCapacity;
    private String licensePlates;
    private AmbulanceType type;
    private AmbulanceKind kind;
}
