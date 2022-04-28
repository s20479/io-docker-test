package com.example.io_backend.model.dto;

import com.example.io_backend.model.enums.AmbulanceKind;
import com.example.io_backend.model.enums.AmbulanceType;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AmbulanceDto {
    @NotNull(message = "Number of seats is is null!!")
    @Positive(message = "Number of seats should be a positive value!")
    private Integer numberOfSeats;
    @NotNull(message = "Fuel tank capacity is is null!!")
    @Positive(message = "Fuel tank capacity should be a positive value!")
    private Integer fuelTankCapacity;
    @NotEmpty
    @NotBlank
    private String licensePlates;
    @NotNull(message = "Ambulance type is null!")
    private AmbulanceType type;
    @NotNull(message = "Ambulance kind is null!")
    private AmbulanceKind kind;
}
