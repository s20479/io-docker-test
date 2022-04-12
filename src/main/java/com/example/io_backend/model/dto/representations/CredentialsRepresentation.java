package com.example.io_backend.model.dto.representations;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CredentialsRepresentation {
    private boolean temporary;
    private String type;
    private String value;
}
