package com.example.io_backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class DummyController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
