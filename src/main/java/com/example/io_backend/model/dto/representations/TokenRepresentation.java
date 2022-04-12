package com.example.io_backend.model.dto.representations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TokenRepresentation {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private Integer expiresIn;
    @JsonProperty("refresh_expires_in")
    private Integer refreshExpiresIn;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("not-before-policy")
    private Integer notBeforePolicy;
    @JsonProperty("scope")
    private String scope;
}
