package com.example.io_backend.model;

import com.example.io_backend.model.enums.StaffType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Table(name = "staff")
@Entity
public class Staff {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.ORDINAL)
    private StaffType staffType;

}
