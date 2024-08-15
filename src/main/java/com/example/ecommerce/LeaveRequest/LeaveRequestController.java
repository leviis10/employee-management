package com.example.ecommerce.LeaveRequest;

import com.example.ecommerce.LeaveRequest.dto.CreateLeaveRequestDTO;
import com.example.ecommerce.LeaveRequest.dto.LeaveRequestResponseDTO;
import com.example.ecommerce.LeaveRequest.dto.UpdateLeaveRequestDTO;
import com.example.ecommerce.common.response.Response;
import com.example.ecommerce.common.response.SuccessResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leave-request")
@RequiredArgsConstructor
public class LeaveRequestController {
    private final LeaveRequestService leaveRequestService;

    @PostMapping
    public ResponseEntity<SuccessResponse<LeaveRequestResponseDTO>> create(
            @Valid @RequestBody CreateLeaveRequestDTO request
    ) {
        return Response.success(leaveRequestService.create(request));
    }

    @GetMapping
    public ResponseEntity<SuccessResponse<List<LeaveRequestResponseDTO>>> findAll() {
        return Response.success(leaveRequestService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<LeaveRequestResponseDTO>> findById(@PathVariable Long id) {
        return Response.success(leaveRequestService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<LeaveRequestResponseDTO>> updateById(
            @PathVariable Long id,
            @Valid @RequestBody UpdateLeaveRequestDTO request
    ) {
        return Response.success(leaveRequestService.updateById(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        leaveRequestService.deleteById(id);
    }
}
