package com.example.io_backend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class CreateUserRequest { // TODO add custom validators for date and phone
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private LocalDate birthDate;
    @NotBlank
    private String phoneNumber;

    @NotBlank
    @JsonProperty("username")
    private String userName;
}
