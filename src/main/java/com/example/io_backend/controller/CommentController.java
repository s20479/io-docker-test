package com.example.io_backend.controller;

import com.example.io_backend.dto.CommentDto;
import com.example.io_backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getComment(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.getComment(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long id, @RequestBody CommentDto comment) {
        return new ResponseEntity<>(commentService.updateComment(id, comment), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CommentDto> postComment(@RequestBody CommentDto comment) {
        return new ResponseEntity<>(commentService.createComment(comment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
