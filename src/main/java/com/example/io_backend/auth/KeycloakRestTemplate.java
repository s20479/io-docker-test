package com.example.io_backend.auth;

import com.example.io_backend.auth.constants.KeycloakApiConstants;
import com.example.io_backend.model.dto.LoginRequest;
import com.example.io_backend.model.dto.representations.TokenRepresentation;
import com.example.io_backend.auth.enums.OAuth2GrantType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@Component
@RequiredArgsConstructor
@Slf4j
public class KeycloakRestTemplate {
    private final RestTemplate restTemplate;

    @Value("${KEYCLOAK_SECRET}")
    private String keycloakSecret;
    @Value("${KEYCLOAK_CLIENTID}")
    private String keycloakClientId;
    @Value("${KEYCLOAK_URL}")
    private String BASE_URL;
    @Value("${KEYCLOAK_REALM}")
    private String REALM;

    public <T> ResponseEntity<T> postForEntity(String url, Object body, Class<T> responseType) {
        HttpEntity<?> httpEntity = new HttpEntity<>(body, getAuthorizationHeader());

        return restTemplate.postForEntity(url, httpEntity, responseType);
    }

    public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType) {
        HttpEntity<?> httpEntity = new HttpEntity<>(getAuthorizationHeader());

        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, responseType); // default getForEntity doesn't support custom headers
    }

    public void put(String url, Object body) {
        HttpEntity<?> httpEntity = new HttpEntity<>(body, getAuthorizationHeader());

        restTemplate.put(url, body);
    }

    private HttpHeaders getAuthorizationHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + postForAccessToken());


        return headers;
    }

    private String postForAccessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> payload = new LinkedMultiValueMap<>();
        payload.add("grant_type", OAuth2GrantType.CLIENT_CREDENTIALS);
        payload.add("client_secret", keycloakSecret);
        payload.add("client_id", keycloakClientId);

        HttpEntity<MultiValueMap<String, String>> tokenRepresentationHttpEntity = new HttpEntity<>(payload, headers);

        String URL = KeycloakApiConstants.createURL( BASE_URL + KeycloakApiConstants.TOKEN,"{REALM}", REALM);

        log.info("Calling: " + URL);
        ResponseEntity<TokenRepresentation> token =  restTemplate.postForEntity(URL, tokenRepresentationHttpEntity, TokenRepresentation.class);

        return Optional.ofNullable(token.getBody()).orElseThrow().getAccessToken();
    }

    public String postForAccessToken(Object object) {
        if (!(object instanceof LoginRequest loginRequest)) {
            throw new RuntimeException("Not a login request!");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> payload = new LinkedMultiValueMap<>();
        payload.add("grant_type", OAuth2GrantType.PASSWORD);
        payload.add("client_secret", keycloakSecret);
        payload.add("client_id", keycloakClientId);
        payload.add("username", loginRequest.getUsername());
        payload.add("password", loginRequest.getPassword());

        HttpEntity<MultiValueMap<String, String>> tokenRepresentationHttpEntity = new HttpEntity<>(payload, headers);

        String URL = KeycloakApiConstants.createURL( BASE_URL + KeycloakApiConstants.TOKEN,"{REALM}", REALM);

        log.info("Calling: " + URL);
        ResponseEntity<TokenRepresentation> token =  restTemplate.postForEntity(URL, tokenRepresentationHttpEntity, TokenRepresentation.class);

        return Optional.ofNullable(token.getBody()).orElseThrow().getAccessToken();
    }

}
