package com.example.io_backend.controller;

import com.example.io_backend.dto.CommentDto;
import com.example.io_backend.model.Tutorial;
import com.example.io_backend.service.CommentService;
import com.example.io_backend.service.TutorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tutorial")
@RequiredArgsConstructor
public class TutorialController {
    private final TutorialService tutorialService;
    private final CommentService commentService;

    @GetMapping("")
    public List<Tutorial> getAll() {
        return tutorialService.getTutorials();
    }

    @GetMapping("/{id}")
    public Tutorial getById(@PathVariable Long id) {
        return tutorialService.getTutorialById(id);
    }

    @GetMapping("/{id}/comments")
    public List<CommentDto> getComments(@PathVariable Long id) {
        return commentService.getTutorialComments(id);
    }

    @PostMapping("")
    public Tutorial add(@RequestBody Tutorial tutorial) {
        return tutorialService.addTutorial(tutorial);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Tutorial tutorial, @PathVariable Long id){
        tutorialService.updateTutorial(tutorial,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        tutorialService.deleteTutorial(id);
    }
}
