package com.example.io_backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class EquipmentDto {

    @NotEmpty(message = "Equipment name shouldn't be empty")
    String name;
}
