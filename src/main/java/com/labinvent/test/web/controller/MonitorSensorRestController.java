package com.labinvent.test.web.controller;

import com.labinvent.test.serivice.MonitorSensorService;
import com.labinvent.test.serivice.dto.MonitorSensorDTO;
import com.labinvent.test.serivice.dto.SearchParameters;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sensors")
public class MonitorSensorRestController {

    private final MonitorSensorService monitorSensorService;

    public MonitorSensorRestController(MonitorSensorService monitorSensorService) {
        this.monitorSensorService = monitorSensorService;
    }

    @GetMapping
    public Page<MonitorSensorDTO> read(@Valid SearchParameters paramsSearch) {
        return monitorSensorService.readAll(paramsSearch);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public MonitorSensorDTO create(@RequestBody @Valid MonitorSensorDTO newMonitorSensorDTO) {
        return monitorSensorService.create(newMonitorSensorDTO);
    }

    @GetMapping(value = "/{id}")
    public MonitorSensorDTO readById(@PathVariable int id) {
        return monitorSensorService.read(id);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public MonitorSensorDTO update(@Valid @RequestBody MonitorSensorDTO dataMonitorSensorDTO, @PathVariable int id) {
        dataMonitorSensorDTO.setId(id);
        return monitorSensorService.create(dataMonitorSensorDTO);
    }

}
