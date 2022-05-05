package com.example.io_backend.service;

import com.example.io_backend.auth.KeycloakRestTemplate;
import com.example.io_backend.auth.constants.KeycloakApiConstants;
import com.example.io_backend.model.Staff;
import com.example.io_backend.model.dto.request.CreateStaffUserRequest;
import com.example.io_backend.model.dto.request.CreateUserRequest;
import com.example.io_backend.model.dto.request.LoginRequest;
import com.example.io_backend.model.dto.representations.CredentialsRepresentation;
import com.example.io_backend.model.dto.representations.UserRepresentation;
import com.example.io_backend.auth.enums.CredentialType;
import com.example.io_backend.model.User;
import com.example.io_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class KeycloakService {
    private final KeycloakRestTemplate keycloakRestTemplate;
    private final UserRepository userRepository;

    @Value("${KEYCLOAK_URL}")
    private String BASE_URL;
    @Value("${KEYCLOAK_REALM}")
    private String REALM;

    public User createUser(CreateUserRequest createUserRequest) {
        log.info("Creating new user with data: " + createUserRequest);

        UserRepresentation userRepresentation = UserRepresentation
                .builder()
                .email(createUserRequest.getEmail())
                .firstName(createUserRequest.getFirstName())
                .lastName(createUserRequest.getLastName())
                .userName(createUserRequest.getUserName())
                .enabled(true)
                .credentials(
                        List.of(
                                CredentialsRepresentation
                                        .builder()
                                        .temporary(false)
                                        .type(CredentialType.PASSWORD)
                                        .value(createUserRequest.getPassword())
                                        .build()
                        )
                )
                .build();
        String URL = KeycloakApiConstants.createURL(BASE_URL + KeycloakApiConstants.USERS,"{REALM}", REALM);
        ResponseEntity<Void> keycloakResponse = keycloakRestTemplate.postForEntity(URL, userRepresentation, Void.class);

        if (keycloakResponse.getStatusCode() == HttpStatus.CREATED) {
            log.info("User created");
            ResponseEntity<UserRepresentation[]> usersResponse = keycloakRestTemplate.getForEntity(URL, UserRepresentation[].class);
            if (!usersResponse.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException("Error creating user!");
            }
            var user =  Arrays.stream(Objects.requireNonNull(usersResponse.getBody())).filter(x -> x.equals(userRepresentation)).toList().get(0);

            User businessUser = User
                    .builder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .phone(createUserRequest.getPhoneNumber())
                    .bandCode(UUID.randomUUID().toString())
                    .birthDate(createUserRequest.getBirthDate())
                    .build();

            businessUser = userRepository.save(businessUser);

            return businessUser;
        }
        return null;
    }

    public List<UserRepresentation> getUsers() {
        String URL = KeycloakApiConstants.createURL(BASE_URL + KeycloakApiConstants.USERS,"{REALM}", REALM);
        log.info("Calling: " + URL);
        ResponseEntity<UserRepresentation[]> usersResponse = keycloakRestTemplate.getForEntity(URL, UserRepresentation[].class);
        if (!usersResponse.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("error");
        }

        return Arrays.asList(Objects.requireNonNull(usersResponse.getBody()));
    }

    public void deleteUser(UserRepresentation userRepresentation) {
        String URL = BASE_URL + KeycloakApiConstants.DELETE_USER.replace("{REALM}", REALM);
        URL = URL.replace("{USER_ID}", userRepresentation.getId());
        keycloakRestTemplate.delete(URL);
    }

    public String loginUser(LoginRequest loginRequest) {
        return keycloakRestTemplate.postForAccessToken(loginRequest);
    }

    public Staff createUser(CreateStaffUserRequest createStaffUserRequest) {
        // todo implement
        throw new NotImplementedException();
    }
}
