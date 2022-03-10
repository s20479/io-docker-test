package com.example.io_backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "medical_info")
@Entity
public class MedicalInfo {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated
    @Column(name = "blood_type")
    private BloodType bloodType;

    @Column(name = "chronic_diseases")
    private String chronicDiseases;

    @Column(name = "allergies")
    private String allergies;

}
