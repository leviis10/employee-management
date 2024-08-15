package com.example.ecommerce.department;

import com.example.ecommerce.department.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    Department create(DepartmentDTO request);

    List<Department> findAll();

    Department findById(Long id);

    Department updateById(Long id, DepartmentDTO request);

    void deleteById(Long id);
}
