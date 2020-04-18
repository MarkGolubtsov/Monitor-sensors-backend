package com.labinvent.task.serivice.impl;

import com.labinvent.task.repository.UnitRepository;
import com.labinvent.task.serivice.UnitService;
import com.labinvent.task.serivice.converter.UnitConverter;
import com.labinvent.task.serivice.dto.UnitDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;

    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public List<UnitDTO> getAll() {
        return unitRepository.findAll().stream().map(UnitConverter::toDTO).collect(Collectors.toList());
    }
}
