package com.labinvent.test.repository.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "unit")
    private Set<MonitorSensor> monitorSensors;

    public long getId() {
        return id;
    }

    public Unit setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Unit setName(String name) {
        this.name = name;
        return this;
    }

    public Set<MonitorSensor> getMonitorSensors() {
        return monitorSensors;
    }

    public Unit setMonitorSensors(Set<MonitorSensor> monitorSensors) {
        this.monitorSensors = monitorSensors;
        return this;
    }
}
