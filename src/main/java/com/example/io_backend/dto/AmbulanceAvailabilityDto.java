package com.example.io_backend.dto;

import com.example.io_backend.model.Ambulance;
import com.example.io_backend.model.enums.AvailabilityType;
import lombok.Data;

import java.util.Date;

@Data
public class AmbulanceAvailabilityDto {

    private Long id;
    private Ambulance ambulance;
    private AvailabilityType availabilityType;
    private Date dateStart;
    private Date dateEnd;
    private String details;





}
