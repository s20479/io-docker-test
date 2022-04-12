package com.example.io_backend.dto;

import com.example.io_backend.model.MedicalInfo;

import java.util.Date;

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
