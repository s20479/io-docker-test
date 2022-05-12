package com.example.io_backend.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class CommentDto {
    Long id;
    String contents;
    @Max(5)
    @Min(1)
    Integer grade;
    Long tutorialId;
    String userId;
}
