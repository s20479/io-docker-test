package com.example.io_backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Table(name = "equipment_log")
@Entity
public class EquipmentLog {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipment_id", unique = true)
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "ambulance_id")
    private Ambulance ambulance;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_start")
    private LocalDate dateStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Column(name = "starting_amount")
    private Double startingAmount;

    @Column(name = "current_amount")
    private Double currentAmount;

    @Column(name = "measurement")
    private String measurement;

}
