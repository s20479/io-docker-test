package com.example.io_backend.controller;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.MedicalInfo;
import com.example.io_backend.model.User;
import com.example.io_backend.repository.UserRepository;
import com.example.io_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("")
    public List<User> getAll() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("")
    public User add(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody User user, @PathVariable Integer id) {
        userService.updateUser(user,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @PostMapping("/info/{id}")
    public void addMedicalInfo(@RequestBody MedicalInfo medicalInfo, @PathVariable Integer id) {
        userService.addUserMedicalInfo(id,medicalInfo);
    }

    @PutMapping("info/{id}")
    public void update(@RequestBody MedicalInfo medicalInfo, @PathVariable Integer id) {
        userService.updateUserMedicalInfo(id, medicalInfo);
    }
}
