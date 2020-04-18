package com.labinvent.task.repository;

import com.labinvent.task.repository.entity.MonitorSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorSensorRepository extends JpaRepository<MonitorSensor, Long>, JpaSpecificationExecutor<MonitorSensor> {
}
