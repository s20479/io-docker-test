package com.example.io_backend.repository;

import com.example.io_backend.model.Comment;
import com.example.io_backend.model.Tutorial;
import com.example.io_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> getAllByUser(User user);

    List<Comment> getAllByUserId(Long userId);

    List<Comment> getAllByTutorial(Tutorial tutorial);

    List<Comment> getAllByTutorialId(Long tutorialId);

    void deleteAllByTutorial(Tutorial tutorial);

    void deleteAllByTutorialId(Long tutorialId);

    void deleteAllByUser(User user);

    void deleteAllByUserId(Long userId);

    List<Comment> getALlByTutorialId(Long tutorialId);
}
