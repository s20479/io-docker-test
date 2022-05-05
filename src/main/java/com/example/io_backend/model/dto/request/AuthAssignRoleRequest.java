package com.example.io_backend.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthAssignRoleRequest {
    @JsonProperty("id")
    private String roleId;
    @JsonProperty("name")
    private String roleName;
}
