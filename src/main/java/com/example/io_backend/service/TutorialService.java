package com.example.io_backend.service;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.Tutorial;
import com.example.io_backend.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TutorialService {

    private final TutorialRepository tutorialRepository;


    public List<Tutorial> getTutorials() {
        return tutorialRepository.findAll();
    }

    public Tutorial getTutorialById(Long id) {
        return tutorialRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with that id"));
    }

    public Tutorial addTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    public void updateTutorial(Tutorial tutorial, Long id) {
        var t = tutorialRepository.findById(id).orElseThrow(() -> new NotFoundException("Tutorial not found"));
        t.setId(tutorial.getId());
        t.setReviewRatingCount(tutorial.getReviewRatingCount());
        t.setReviewRatingSum(tutorial.getReviewRatingSum());
        t.setName(tutorial.getName());
        t.setTutorialKind(tutorial.getTutorialKind());

        tutorialRepository.save(t);

    }

    public void deleteTutorial(Long id) {
        var t = tutorialRepository.findById(id).orElseThrow(() -> new NotFoundException("Person not found"));
        tutorialRepository.delete(t);
    }
}
