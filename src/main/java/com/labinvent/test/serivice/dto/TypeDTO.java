package com.labinvent.test.serivice.dto;

import javax.validation.constraints.NotNull;

public class TypeDTO extends EntityDTO {
    @NotNull(message = "Please provide a name")
    private String name;
}
