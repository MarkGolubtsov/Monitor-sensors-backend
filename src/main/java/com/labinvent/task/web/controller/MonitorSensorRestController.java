package com.labinvent.task.web.controller;

import com.labinvent.task.serivice.MonitorSensorService;
import com.labinvent.task.serivice.dto.MonitorSensorDTO;
import com.labinvent.task.serivice.dto.SearchParameters;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sensors")
public class MonitorSensorRestController {

    private final MonitorSensorService monitorSensorService;

    public MonitorSensorRestController(MonitorSensorService monitorSensorService) {
        this.monitorSensorService = monitorSensorService;
    }

    @PreAuthorize(" hasAnyRole('VIEWER','ADMIN')")
    @GetMapping
    public Page<MonitorSensorDTO> read(@Valid SearchParameters paramsSearch) {
        return monitorSensorService.readAll(paramsSearch);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public MonitorSensorDTO create(@RequestBody @Valid MonitorSensorDTO newMonitorSensorDTO) {
        return monitorSensorService.create(newMonitorSensorDTO);
    }

    @PreAuthorize(" hasAnyRole('VIEWER','ADMIN')")
    @GetMapping(value = "/{id}")
    public MonitorSensorDTO readById(@PathVariable int id) {
        return monitorSensorService.read(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public MonitorSensorDTO update(@Valid @RequestBody MonitorSensorDTO dataMonitorSensorDTO, @PathVariable int id) {
        dataMonitorSensorDTO.setId(id);
        return monitorSensorService.create(dataMonitorSensorDTO);
    }

}
