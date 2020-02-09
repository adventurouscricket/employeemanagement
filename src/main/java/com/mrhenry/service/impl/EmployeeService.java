package com.mrhenry.service.impl;

import com.mrhenry.dto.EmployeeDTO;
import com.mrhenry.entity.EmployeeEntity;
import com.mrhenry.repository.IEmployeeRepository;
import com.mrhenry.service.IEmployeeService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService  implements IEmployeeService {

    @Inject
    private IEmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO save(EmployeeDTO employee) {
        if (employeeRepository.insert(convertToEntity(employee)) != null) {
            return employee;
        }
        return null;
    }

    @Override
    public void update(EmployeeDTO employee, Long id) {
        employeeRepository.update(convertToEntity(employee), id);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        for (EmployeeEntity employeeEntity: employeeEntities ) {
            employeeDTOs.add(convertToDto(employeeEntity));
        }
        return employeeDTOs;
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public EmployeeDTO findById(Long id) {
        return convertToDto(employeeRepository.findById(id));
    }

    private EmployeeDTO convertToDto(EmployeeEntity entity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(entity.getId());
        employeeDTO.setName(entity.getName());
        employeeDTO.setGrid(entity.getGrid());
        return employeeDTO;
    }

    private EmployeeEntity convertToEntity(EmployeeDTO entity) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(entity.getId());
        employeeEntity.setName(entity.getName());
        employeeEntity.setGrid(entity.getGrid());
        return employeeEntity;
    }
}
