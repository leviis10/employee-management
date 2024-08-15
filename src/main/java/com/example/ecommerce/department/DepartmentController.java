package com.example.ecommerce.department;

import com.example.ecommerce.common.response.Response;
import com.example.ecommerce.common.response.SuccessResponse;
import com.example.ecommerce.department.dto.DepartmentDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<SuccessResponse<Department>> create(
            @Valid @RequestBody DepartmentDTO request
    ) {
        return Response.success(departmentService.create(request));
    }

    @GetMapping
    public ResponseEntity<SuccessResponse<List<Department>>> findAll() {
        return Response.success(departmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<Department>> findById(@PathVariable Long id) {
        return Response.success(departmentService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<Department>> updateById(
            @PathVariable Long id,
            @Valid @RequestBody DepartmentDTO request
    ) {
        return Response.success(departmentService.updateById(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        departmentService.deleteById(id);
    }
}
