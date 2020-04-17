package com.labinvent.test.repository.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy="type")
    private Set<MonitorSensor> monitorSensors;

    public long getId() {
        return id;
    }

    public Type setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Type setName(String name) {
        this.name = name;
        return this;
    }

    public Set<MonitorSensor> getMonitorSensors() {
        return monitorSensors;
    }

    public Type setMonitorSensors(Set<MonitorSensor> monitorSensors) {
        this.monitorSensors = monitorSensors;
        return this;
    }
}
