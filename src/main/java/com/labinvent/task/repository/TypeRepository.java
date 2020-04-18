package com.labinvent.task.repository;

import com.labinvent.task.repository.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
