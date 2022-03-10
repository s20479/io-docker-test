package com.example.io_backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "review")
@Entity
public class Review {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "content")
    private String content;

}
