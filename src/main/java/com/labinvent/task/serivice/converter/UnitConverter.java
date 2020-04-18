package com.labinvent.task.serivice.converter;

import com.labinvent.task.repository.entity.Unit;
import com.labinvent.task.serivice.dto.UnitDTO;

public class UnitConverter {
    private UnitConverter() { }

    public static Unit fromDTO(UnitDTO unitDTO) {
        Unit unit = new Unit();
        unit.setId(unitDTO.getId()).setName(unitDTO.getName());
        return unit;
    }

    public static UnitDTO toDTO(Unit unit) {
        UnitDTO unitDTO = new UnitDTO();
        unitDTO.setName(unit.getName()).setId(unit.getId());
        return unitDTO;
    }
}
