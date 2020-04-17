package com.labinvent.test.repository;

import com.labinvent.test.repository.entity.MonitorSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorSensorRepository extends JpaRepository<MonitorSensor, Long> {
}
