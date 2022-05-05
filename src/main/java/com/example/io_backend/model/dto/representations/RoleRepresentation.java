package com.example.io_backend.model.dto.representations;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleRepresentation {
    private String id;
    private String name;
    private boolean composite;
    private boolean clientRole;
    private String containerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleRepresentation that = (RoleRepresentation) o;
        return composite == that.composite && clientRole == that.clientRole && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(containerId, that.containerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, composite, clientRole, containerId);
    }
}
