package com.example.ecommerce.LeaveRequest;

import com.example.ecommerce.LeaveRequest.dto.CreateLeaveRequestDTO;
import com.example.ecommerce.LeaveRequest.dto.LeaveRequestResponseDTO;
import com.example.ecommerce.LeaveRequest.dto.UpdateLeaveRequestDTO;

import java.util.List;

public interface LeaveRequestService {
    LeaveRequestResponseDTO create(CreateLeaveRequestDTO request);

    List<LeaveRequestResponseDTO> findAll();

    LeaveRequestResponseDTO findById(Long id);

    LeaveRequestResponseDTO updateById(Long id, UpdateLeaveRequestDTO request);

    void deleteById(Long id);
}
