package com.labinvent.task.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "monitor_sensors")
public class MonitorSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "range_from")
    private int rangeFrom;

    @Column(name = "range_to")
    private int rangeTo;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    public long getId() {
        return id;
    }

    public MonitorSensor setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MonitorSensor setName(String name) {
        this.name = name;
        return this;
    }

    public String getModel() {
        return model;
    }

    public MonitorSensor setModel(String model) {
        this.model = model;
        return this;
    }

    public int getRangeFrom() {
        return rangeFrom;
    }

    public MonitorSensor setRangeFrom(int rangeFrom) {
        this.rangeFrom = rangeFrom;
        return this;
    }

    public int getRangeTo() {
        return rangeTo;
    }

    public MonitorSensor setRangeTo(int rangeTo) {
        this.rangeTo = rangeTo;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public MonitorSensor setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MonitorSensor setDescription(String description) {
        this.description = description;
        return this;
    }

    public Type getType() {
        return type;
    }

    public MonitorSensor setType(Type type) {
        this.type = type;
        return this;
    }

    public Unit getUnit() {
        return unit;
    }

    public MonitorSensor setUnit(Unit unit) {
        this.unit = unit;
        return this;
    }
}
