package com.example.io_backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "comment")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String contents;

    @Column(name = "grade")
    private Integer grade;

    @ManyToOne
    @Column(name = "tutorial")
    private Tutorial tutorial;

    @ManyToOne
    @Column(name = "user")
    private User user;
}
