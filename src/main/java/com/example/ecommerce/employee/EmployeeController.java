package com.example.ecommerce.employee;

import com.example.ecommerce.common.response.Response;
import com.example.ecommerce.common.response.SuccessResponse;
import com.example.ecommerce.employee.dto.CreateEmployeeDTO;
import com.example.ecommerce.employee.dto.EmployeeResponseDTO;
import com.example.ecommerce.employee.dto.UpdateEmployeeDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<SuccessResponse<EmployeeResponseDTO>> create(
            @Valid @RequestBody CreateEmployeeDTO request
    ) {
        return Response.success(HttpStatus.CREATED, employeeService.create(request));
    }

    @GetMapping
    public ResponseEntity<SuccessResponse<List<EmployeeResponseDTO>>> findAll() {
        return Response.success(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<EmployeeResponseDTO>> findById(@PathVariable Long id) {
        return Response.success(employeeService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<EmployeeResponseDTO>> updateById(
            @PathVariable Long id,
            @Valid @RequestBody UpdateEmployeeDTO request
    ) {
        return Response.success(employeeService.updateById(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
    }
}
