package com.example.io_backend.model.dto.response;

import com.example.io_backend.model.Ambulance;
import com.example.io_backend.model.Equipment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class EquipmentLogResponse {
    private Equipment equipment;
    private Ambulance ambulance;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private Double startingAmount;
    private Double currentAmount;
    private String measurement;
}
