package com.example.io_backend.model.dto.request;

import com.example.io_backend.model.enums.StaffType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateStaffUserRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String phone;
    private StaffType staffType;
}
