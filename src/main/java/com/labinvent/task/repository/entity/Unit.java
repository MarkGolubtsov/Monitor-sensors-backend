package com.labinvent.task.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

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

}
