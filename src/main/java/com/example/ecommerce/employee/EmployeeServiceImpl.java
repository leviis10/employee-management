package com.example.ecommerce.employee;

import com.example.ecommerce.employee.dto.CreateEmployeeDTO;
import com.example.ecommerce.employee.dto.EmployeeResponseDTO;
import com.example.ecommerce.employee.dto.UpdateEmployeeDTO;
import com.example.ecommerce.employee.exception.EmployeeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponseDTO create(CreateEmployeeDTO request) {
        return EmployeeResponseDTO.toDTO(employeeRepository.save(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPhone(),
                request.getHireDate(),
                request.getDepartmentId()
        ));
    }

    @Override
    public List<EmployeeResponseDTO> findAll() {
        return employeeRepository.findAllNative()
                .stream()
                .map(EmployeeResponseDTO::toDTO)
                .toList();
    }

    @Override
    public EmployeeResponseDTO findById(Long id) {
        Employee foundEmployee = employeeRepository.findByIdNative(id);
        if (foundEmployee == null) {
            throw new EmployeeNotFoundException();
        }

        return EmployeeResponseDTO.toDTO(foundEmployee);
    }

    @Override
    public EmployeeResponseDTO updateById(Long id, UpdateEmployeeDTO request) {
        return EmployeeResponseDTO.toDTO(employeeRepository.updateById(
                id,
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPhone(),
                request.getDepartmentId()
        ));
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
