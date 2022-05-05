package com.example.io_backend.repository;

import com.example.io_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User getById(String id);
}