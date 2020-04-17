package com.labinvent.test.serivice.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class MonitorSensorDTO extends EntityDTO {

    @NotNull(message = "Please provide a name")
    @Length(max = 30, message = "Please, provide shorter(less 30 symbols) a name.")
    private String name;

    @NotNull(message = "Please provide  a model")
    @Length(max = 15, message = "Please, provide shorter(less 15 symbols) a model.")
    private String model;


    @Length(max = 40, message = "Please, provide shorter(less 40 symbols) a location.")
    private String location;

    @Length(max = 200, message = "Please, provide shorter(less 200 symbols) a description.")
    private String description;

    private int rangeFrom;

    private int rangeTo;

    private TypeDTO typeDTO;

    private UnitDTO unitDTO;

    public String getName() {
        return name;
    }

    public MonitorSensorDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getModel() {
        return model;
    }

    public MonitorSensorDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public MonitorSensorDTO setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MonitorSensorDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getRangeFrom() {
        return rangeFrom;
    }

    public MonitorSensorDTO setRangeFrom(int rangeFrom) {
        this.rangeFrom = rangeFrom;
        return this;
    }

    public int getRangeTo() {
        return rangeTo;
    }

    public MonitorSensorDTO setRangeTo(int rangeTo) {
        this.rangeTo = rangeTo;
        return this;
    }

    public TypeDTO getTypeDTO() {
        return typeDTO;
    }

    public MonitorSensorDTO setTypeDTO(TypeDTO typeDTO) {
        this.typeDTO = typeDTO;
        return this;
    }

    public UnitDTO getUnitDTO() {
        return unitDTO;
    }

    public MonitorSensorDTO setUnitDTO(UnitDTO unitDTO) {
        this.unitDTO = unitDTO;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonitorSensorDTO that = (MonitorSensorDTO) o;
        return rangeFrom == that.rangeFrom &&
                rangeTo == that.rangeTo &&
                name.equals(that.name) &&
                model.equals(that.model) &&
                Objects.equals(location, that.location) &&
                Objects.equals(description, that.description) &&
                typeDTO.equals(that.typeDTO) &&
                unitDTO.equals(that.unitDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model, location, description, rangeFrom, rangeTo, typeDTO, unitDTO);
    }
}
