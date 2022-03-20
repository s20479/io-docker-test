package com.example.io_backend.model;

import com.example.io_backend.model.enums.AvailabilityType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "ambulance_availability")
@Entity
public class AmbulanceAvailability {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ambulance_id")
    private Ambulance ambulance;

    @Enumerated
    @Column(name = "availability_type")
    private AvailabilityType availabilityType;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_start")
    private Date dateStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "details")
    private String details;

}
