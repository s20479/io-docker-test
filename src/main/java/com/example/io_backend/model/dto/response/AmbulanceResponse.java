package com.example.io_backend.model.dto.response;

import com.example.io_backend.model.Ambulance;
import com.example.io_backend.model.AmbulanceAvailability;
import com.example.io_backend.model.enums.AmbulanceKind;
import com.example.io_backend.model.enums.AmbulanceType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AmbulanceResponse {
    private Integer numberOfSeats;
    private Integer fuelTankCapacity;
    private String licensePlates;
    private AmbulanceType type;
    private AmbulanceKind kind;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AmbulanceAvailability availability;

    public static AmbulanceResponse of(Ambulance ambulance) {
        return AmbulanceResponse
                .builder()
                .fuelTankCapacity(ambulance.getFuelCapacity())
                .licensePlates(ambulance.getPlates())
                .type(ambulance.getAmbulanceType())
                .kind(ambulance.getAmbulanceKind())
                .numberOfSeats(ambulance.getPeopleCapacity())
                .build();
    }
}
