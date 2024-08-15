package com.example.ecommerce.department;

import com.example.ecommerce.department.dto.DepartmentDTO;
import com.example.ecommerce.department.exception.DepartmentNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department create(DepartmentDTO request) {
        return departmentRepository.save(request.getDepartmentName());
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAllNative();
    }

    @Override
    public Department findById(Long id) {
        Department foundDepartment = departmentRepository.findByIdNative(id);
        if (foundDepartment == null) {
            throw new DepartmentNotFoundException();
        }

        return foundDepartment;
    }

    @Override
    public Department updateById(Long id, DepartmentDTO request) {
        Department updatedDepartment = departmentRepository.updateById(id, request.getDepartmentName());
        if (updatedDepartment == null) {
            throw new DepartmentNotFoundException();
        }

        return updatedDepartment;
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteByIdNative(id);
    }
}
