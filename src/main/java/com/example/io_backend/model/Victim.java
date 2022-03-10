package com.example.io_backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "victim")
@Entity
public class Victim {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "document_id")
    private String documentId;

    @ManyToOne
    @JoinColumn(name = "medical_info_id")
    private MedicalInfo medicalInfo;

}
