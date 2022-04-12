package com.example.io_backend.controller;

import com.example.io_backend.model.Staff;
import com.example.io_backend.model.User;
import com.example.io_backend.model.dto.CreateStaffUserRequest;
import com.example.io_backend.model.dto.CreateUserRequest;
import com.example.io_backend.model.dto.LoginRequest;
import com.example.io_backend.service.KeycloakService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final KeycloakService keycloakService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        log.info("User with username: " + loginRequest.getUsername() + " attempted to login");
        String token = keycloakService.loginUser(loginRequest);

        return ResponseEntity.ok(token);
    }

    @PostMapping("/register/normal")
    public ResponseEntity<User> registerUser(@RequestBody CreateUserRequest createUserRequest) {
        log.info("Calling Keycloak service...");
        var user = keycloakService.createUser(createUserRequest);

        return user == null ?
                ResponseEntity.internalServerError().build() :
                ResponseEntity.ok(user);
    }

    @PostMapping("/register/staff")
    public ResponseEntity<Staff> registerStaffUser(@RequestBody CreateStaffUserRequest createStaffUserRequest) {
        log.info("Calling Keycloak service...");
        var staffUser = keycloakService.createUser(createStaffUserRequest);

        return staffUser == null ?
                ResponseEntity.internalServerError().build() :
                ResponseEntity.ok(staffUser);

    }
}
