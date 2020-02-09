package com.mrhenry.repository;

import com.mrhenry.entity.EmployeeEntity;

import java.util.List;

public interface IEmployeeRepository {
    void update(EmployeeEntity entity, Long id);
    Long insert(EmployeeEntity entity);
    void delete(Long id);
    List<EmployeeEntity> findAll();
    EmployeeEntity findById(Long id);
}
