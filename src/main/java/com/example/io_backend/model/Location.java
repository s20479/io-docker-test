package com.example.io_backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "location")
@Entity
public class Location {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Integer id;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

}
