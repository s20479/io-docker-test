package com.example.io_backend.model;

import com.example.io_backend.model.enums.TutorialKind;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Table(name = "tutorial")
@Entity
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated
    @Column(name = "tutorial_kind")
    private TutorialKind tutorialKind;

    @Column(name = "review_rating_sum")
    private Integer reviewRatingSum;

    @Column(name = "review_rating_count")
    private Integer reviewRatingCount;

    @OneToMany
    @Column(name = "comment")
    private List<Comment> comments;

}
