package com.example.io_backend.controller;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.Person;
import com.example.io_backend.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping("/person")
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public Person getById(@PathVariable Integer id) {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with that id"));
    }

    @PostMapping("/person")
    public Person add(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/person/{id}")
    public void update(@RequestBody Person person, @PathVariable Integer id) {
        var p = personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person not found"));
        p.setId(person.getId());
        p.setName(person.getName());

        personRepository.save(p);
    }

    @DeleteMapping("/person/{id}")
    public void delete(@PathVariable Integer id) {
        var p = personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person not found"));
        personRepository.delete(p);
    }
}
