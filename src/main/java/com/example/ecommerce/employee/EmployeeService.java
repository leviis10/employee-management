package com.example.ecommerce.employee;

import com.example.ecommerce.employee.dto.CreateEmployeeDTO;
import com.example.ecommerce.employee.dto.EmployeeResponseDTO;
import com.example.ecommerce.employee.dto.UpdateEmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO create(CreateEmployeeDTO request);

    List<EmployeeResponseDTO> findAll();

    EmployeeResponseDTO findById(Long id);

    EmployeeResponseDTO updateById(Long id, UpdateEmployeeDTO request);

    void deleteById(Long id);
}
