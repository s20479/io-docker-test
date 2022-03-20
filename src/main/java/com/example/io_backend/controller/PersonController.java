package com.example.io_backend.controller;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.User;
import com.example.io_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/person")
@RequiredArgsConstructor
public class PersonController {
    private final UserRepository userRepository;

    @GetMapping("")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with that id"));
    }

    @PostMapping("")
    public User add(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody User user, @PathVariable Integer id) {
        var p = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Person not found"));
        p.setId(user.getId());
        p.setFirstName(user.getFirstName());
        p.setLastName(user.getLastName());

        userRepository.save(p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        var p = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Person not found"));
        userRepository.delete(p);
    }
}
