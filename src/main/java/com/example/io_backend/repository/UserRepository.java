package com.example.io_backend.repository;

import com.example.io_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User getById(String id);
    public Optional<User> findById(String id);
}