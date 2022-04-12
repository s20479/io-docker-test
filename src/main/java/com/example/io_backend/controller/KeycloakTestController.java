package com.example.io_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController()
@RequestMapping(path = "/test")
public class KeycloakTestController {

    @GetMapping("/user")
    public ResponseEntity<String> helloUser(Authentication authentication) {
        JwtAuthenticationToken token = (JwtAuthenticationToken) authentication;
        return ResponseEntity.ok("user " + token.getToken().getClaimAsString("preferred_username"));
    }

    @GetMapping("/staff")
    public ResponseEntity<String> helloStaff(Authentication authentication) {
        JwtAuthenticationToken token = (JwtAuthenticationToken) authentication;
        return ResponseEntity.ok("staff " + token.getToken().getClaimAsString("preferred_username"));
    }

    @GetMapping("/anon")
    public ResponseEntity<String> hello(Authentication authentication) {
        System.out.println(authentication);
        return ResponseEntity.ok("anonymous " + authentication);
    }
}
