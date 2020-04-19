package com.labinvent.task.serivice.impl;

import com.labinvent.task.repository.MonitorSensorRepository;
import com.labinvent.task.repository.entity.MonitorSensor;
import com.labinvent.task.repository.specification.MonitorSensorProperties;
import com.labinvent.task.repository.specification.MonitorSensorSpecificationFactory;
import com.labinvent.task.serivice.MonitorSensorService;
import com.labinvent.task.serivice.converter.MonitorSensorConverter;
import com.labinvent.task.serivice.dto.MonitorSensorDTO;
import com.labinvent.task.serivice.dto.SearchParameters;
import com.labinvent.task.serivice.exception.BadEntityException;
import com.labinvent.task.serivice.exception.NotFoundEntityException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MonitorSensorServiceImpl implements MonitorSensorService {

    private static final String BAD_RANGE = "Range is not valid.";
    private static final String NOT_EXIST_ID = "Not exist monitor sensor  with id = %s";

    private final MonitorSensorRepository monitorSensorRepository;

    public MonitorSensorServiceImpl(MonitorSensorRepository monitorSensorRepository) {
        this.monitorSensorRepository = monitorSensorRepository;
    }


    @Override
    public MonitorSensorDTO create(MonitorSensorDTO entity) {
        if (entity.getRangeFrom() <= entity.getRangeTo()) {
           return MonitorSensorConverter.toDTO(monitorSensorRepository.save(MonitorSensorConverter.fromDTO(entity)));
        }
        throw new BadEntityException(BAD_RANGE);
    }

    @Override
    public Page<MonitorSensorDTO> readAll(SearchParameters parameters) {
        Pageable paging = PageRequest.of(parameters.getPage(), parameters.getPageSize(), Sort.by("id"));
        Specification<MonitorSensor> specification = builtSpecification(parameters);
        Page<MonitorSensor> pagedResult = monitorSensorRepository.findAll(specification, paging);
        Page<MonitorSensorDTO> monitorSensorDTOList = pagedResult.map(MonitorSensorConverter::toDTO);
        return monitorSensorDTOList;
    }

    @Override
    public MonitorSensorDTO read(long id) {
        return monitorSensorRepository.findById(id).map(MonitorSensorConverter::toDTO)
                .orElseThrow(() -> new NotFoundEntityException(String.format(NOT_EXIST_ID, id)));
    }

    @Override
    public void delete(long id) {
        monitorSensorRepository.deleteById(id);
    }

    @Override
    public MonitorSensorDTO update(MonitorSensorDTO entity) {
        return MonitorSensorConverter.toDTO(monitorSensorRepository.save(MonitorSensorConverter.fromDTO(entity)));
    }

    private Specification<MonitorSensor> builtSpecification(SearchParameters searchParameters) {
        String text = searchParameters.getText();
        Specification<MonitorSensor> specification = (root, query, criteriaBuilder) -> criteriaBuilder.isNotNull(root.get(MonitorSensorProperties.ID));

        if (!StringUtils.isEmpty(text)) {
            specification = specification.and(MonitorSensorSpecificationFactory.getMonitorSensorsByLikeName(text)
                    .or(MonitorSensorSpecificationFactory.getMonitorSensorsByLikeModel(text))
                    .or(MonitorSensorSpecificationFactory.getMonitorSensorsByLikeType(text))
                    .or(MonitorSensorSpecificationFactory.getMonitorSensorsByLikeUnit(text))
                    .or(MonitorSensorSpecificationFactory.getMonitorSensorsByLikeLocation(text))
                    .or(MonitorSensorSpecificationFactory.getMonitorSensorsByLikeDescription(text)));
        }
        return specification;
    }

}
