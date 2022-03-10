package com.example.io_backend.controller;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.User;
import com.example.io_backend.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping("")
    public List<User> getAll() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with that id"));
    }

    @PostMapping("")
    public User add(@RequestBody User user) {
        return personRepository.save(user);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody User user, @PathVariable Integer id) {
        var p = personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person not found"));
        p.setId(user.getId());
        p.setName(user.getName());

        personRepository.save(p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        var p = personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person not found"));
        personRepository.delete(p);
    }
}
