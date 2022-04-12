package com.example.io_backend.model.dto.representations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class UserRepresentation {
    public UserRepresentation() {}

    private String firstName;
    private String lastName;
    @JsonProperty("username")
    private String userName;
    private String email;
    private boolean enabled;
    private List<CredentialsRepresentation> credentials;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRepresentation that = (UserRepresentation) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, userName);
    }
}
