package com.labinvent.test.serivice.dto;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class UnitDTO extends EntityDTO {

    @NotNull(message = "Please provide a name")
    private String name;

    public String getName() {
        return name;
    }

    public UnitDTO setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitDTO unitDTO = (UnitDTO) o;
        return name.equals(unitDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
