package com.labinvent.task.serivice.impl;

import com.labinvent.task.repository.TypeRepository;
import com.labinvent.task.serivice.TypeService;
import com.labinvent.task.serivice.converter.TypeConverter;
import com.labinvent.task.serivice.dto.TypeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }


    @Override
    public List<TypeDTO> getAll() {
        return typeRepository.findAll().stream().map(TypeConverter::toDTO).collect(Collectors.toList());
    }
}
