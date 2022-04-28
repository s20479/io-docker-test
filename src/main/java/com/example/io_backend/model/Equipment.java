package com.example.io_backend.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "equipment")
@Entity
public class Equipment {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return id.equals(equipment.id) && name.equals(equipment.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
