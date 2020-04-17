package com.labinvent.test.serivice.converter;

import com.labinvent.test.repository.entity.Type;
import com.labinvent.test.serivice.dto.TypeDTO;

public class TypeConverter {
    private TypeConverter() { }

    public static Type fromDTO(TypeDTO typeDTO) {
        Type type = new Type();
        type.setId(typeDTO.getId()).setName(typeDTO.getName());
        return type;
    }

    public static TypeDTO toDTO(Type type) {
        TypeDTO typeDTO = new TypeDTO();
        typeDTO.setName(type.getName()).setId(type.getId());
        return typeDTO;
    }
}
