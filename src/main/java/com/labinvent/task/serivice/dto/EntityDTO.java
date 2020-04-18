package com.labinvent.task.serivice.dto;

public abstract class EntityDTO {

    private long id;

    public long getId() {
        return id;
    }

    public EntityDTO setId(long id) {
        this.id = id;
        return this;
    }
}
