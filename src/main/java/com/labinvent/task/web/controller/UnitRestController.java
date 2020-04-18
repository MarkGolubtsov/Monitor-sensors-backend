package com.labinvent.task.web.controller;

import com.labinvent.task.serivice.UnitService;
import com.labinvent.task.serivice.dto.UnitDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/units")
public class UnitRestController {

    private final UnitService unitService;

    public UnitRestController(UnitService unitService) {
        this.unitService = unitService;
    }


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UnitDTO> readAll() {
        return unitService.getAll();
    }
}
