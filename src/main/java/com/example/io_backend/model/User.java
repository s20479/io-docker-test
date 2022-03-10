package com.example.io_backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name = "email")
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "band_code")
    private String bandCode;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "medical_info_id")
    private MedicalInfo medicalInfo;

}
