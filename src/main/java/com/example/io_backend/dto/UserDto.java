package com.example.io_backend.dto;

import com.example.io_backend.model.MedicalInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    Integer id;
    String firstName;
    String lastName;
    String password;
    String email;
    Date birthDate;
    String phone;
    String bandCode;
    MedicalInfo medicalInfo;
}
