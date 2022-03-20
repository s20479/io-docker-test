package com.example.io_backend.model;

import com.example.io_backend.model.enums.StaffType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "staff")
@Entity
public class Staff {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "mail")
    private String mail;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "salt")
    private String salt;

    @Enumerated(EnumType.ORDINAL)
    private StaffType staffType;

}
