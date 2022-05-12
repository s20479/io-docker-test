package com.example.io_backend.service;

import com.example.io_backend.dto.CommentDto;
import com.example.io_backend.model.Comment;
import com.example.io_backend.model.Tutorial;
import com.example.io_backend.model.User;
import com.example.io_backend.repository.CommentRepository;
import com.example.io_backend.repository.TutorialRepository;
import com.example.io_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TutorialRepository tutorialRepository;

    public CommentDto getComment(Long commentId) {
        return mapToDto(commentRepository.getById(commentId));
    }

    public List<CommentDto> getTutorialComments(Long tutorialId) {
        return commentRepository.getAllByTutorialId(tutorialId).stream().map(it -> mapToDto(it)).collect(Collectors.toList());
    }

    public CommentDto updateComment(Long commentId, CommentDto commentDto) {
        Comment comment = commentRepository.getById(commentId);
        if(comment == null) {
            throw new RuntimeException("Couldn't find comment by ID: " + commentId);
        }

        boolean updateAverage = false;
        if(comment.getGrade() != commentDto.getGrade()) {
            updateAverage = true;
        }

        comment.setContents(commentDto.getContents());
        comment.setGrade(commentDto.getGrade());
        if(updateAverage) {
            var average = commentRepository.getAllByTutorial(comment.getTutorial()).stream().mapToDouble(it -> it.getGrade()).average();
            comment.getTutorial().setAverage(average.getAsDouble());
        }

        return mapToDto(commentRepository.save(comment));
    }

    public CommentDto createComment(CommentDto commentDto) {
        User user = userRepository.getById(commentDto.getUserId());
        if(user == null) {
            throw new RuntimeException("Couldn't find user by ID: " + commentDto.getUserId());
        }

        Tutorial tutorial = tutorialRepository.getById(commentDto.getTutorialId());
        if(tutorial == null) {
            throw new RuntimeException("Couldn't find tutorial by ID: " + commentDto.getTutorialId());
        }

        Comment comment = new Comment();
        comment.setTutorial(tutorial);
        comment.setUser(user);
        comment.setContents(commentDto.getContents());
        comment.setGrade(commentDto.getGrade());

        return mapToDto(commentRepository.save(comment));
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public CommentDto mapToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();

        commentDto.setId(comment.getId());
        commentDto.setContents(comment.getContents());
        commentDto.setGrade(comment.getGrade());
        commentDto.setTutorialId(comment.getTutorial().getId());
        commentDto.setUserId(comment.getUser().getId());

        return commentDto;
    }
}
