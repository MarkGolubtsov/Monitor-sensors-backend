package com.labinvent.test.serivice.converter;

import com.labinvent.test.repository.entity.Unit;
import com.labinvent.test.serivice.dto.UnitDTO;

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
