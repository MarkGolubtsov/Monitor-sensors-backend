package com.labinvent.task.web.controller;

import com.labinvent.task.serivice.TypeService;
import com.labinvent.task.serivice.dto.TypeDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeRestController {

    private final TypeService typeService;

    public TypeRestController(TypeService typeService) {
        this.typeService = typeService;
    }


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<TypeDTO> readAll() {
        return typeService.getAll();
    }
}
