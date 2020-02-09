package com.mrhenry.service;

import com.mrhenry.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    EmployeeDTO save(EmployeeDTO employee);
    void update(EmployeeDTO employee, Long id);
    List<EmployeeDTO> findAll();
    void delete(Long id);
    EmployeeDTO findById(Long id);
}
