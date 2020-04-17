package com.labinvent.test.serivice.converter;

import com.labinvent.test.repository.entity.MonitorSensor;
import com.labinvent.test.serivice.dto.MonitorSensorDTO;

public class MonitorSensorConverter {
    private MonitorSensorConverter(){}


    public static MonitorSensor fromDTO(MonitorSensorDTO monitorSensorDTO) {
        MonitorSensor monitorSensor = new MonitorSensor();
        monitorSensor.setId(monitorSensorDTO.getId())
                .setDescription(monitorSensorDTO.getDescription())
                .setLocation(monitorSensorDTO.getLocation())
                .setType(TypeConverter.fromDTO(monitorSensorDTO.getTypeDTO()))
                .setRangeFrom(monitorSensorDTO.getRangeFrom())
                .setRangeTo(monitorSensorDTO.getRangeTo())
                .setModel(monitorSensorDTO.getModel())
                .setName(monitorSensorDTO.getName())
                .setUnit(UnitConverter.fromDTO(monitorSensorDTO.getUnitDTO()));
        return monitorSensor;
    }

    public static MonitorSensorDTO toDTO(MonitorSensor monitorSensor) {
        MonitorSensorDTO monitorSensorDTO = new MonitorSensorDTO();
        monitorSensorDTO.setDescription(monitorSensor.getDescription())
                .setLocation(monitorSensor.getLocation())
                .setTypeDTO(TypeConverter.toDTO(monitorSensor.getType()))
                .setRangeFrom(monitorSensor.getRangeFrom())
                .setRangeTo(monitorSensor.getRangeTo())
                .setModel(monitorSensor.getModel())
                .setUnitDTO(UnitConverter.toDTO(monitorSensor.getUnit()))
                .setName(monitorSensor.getName())
                .setId(monitorSensor.getId());
        return monitorSensorDTO;
    }
}
