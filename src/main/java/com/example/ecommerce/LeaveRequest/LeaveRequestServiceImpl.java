package com.example.ecommerce.LeaveRequest;

import com.example.ecommerce.LeaveRequest.dto.CreateLeaveRequestDTO;
import com.example.ecommerce.LeaveRequest.dto.LeaveRequestResponseDTO;
import com.example.ecommerce.LeaveRequest.dto.UpdateLeaveRequestDTO;
import com.example.ecommerce.LeaveRequest.exception.LeaveRequestNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaveRequestServiceImpl implements LeaveRequestService {
    private final LeaveRequestRepository leaveRequestRepository;


    @Override
    public LeaveRequestResponseDTO create(CreateLeaveRequestDTO request) {
        return LeaveRequestResponseDTO.toDTO(leaveRequestRepository.save(
                request.getEmployeeId(),
                request.getStartDate(),
                request.getEndDate(),
                request.getLeaveType(),
                request.getStatus()
        ));
    }

    @Override
    public List<LeaveRequestResponseDTO> findAll() {
        return leaveRequestRepository.findAllNative()
                .stream()
                .map(LeaveRequestResponseDTO::toDTO)
                .toList();
    }

    @Override
    public LeaveRequestResponseDTO findById(Long id) {
        LeaveRequest foundLeaveRequest = leaveRequestRepository.findByIdNative(id);
        if (foundLeaveRequest == null) {
            throw new LeaveRequestNotFoundException();
        }

        return LeaveRequestResponseDTO.toDTO(foundLeaveRequest);
    }

    @Override
    public LeaveRequestResponseDTO updateById(Long id, UpdateLeaveRequestDTO request) {
        return LeaveRequestResponseDTO.toDTO(leaveRequestRepository.updateById(
                id,
                request.getStartDate(),
                request.getEndDate(),
                request.getLeaveType(),
                request.getStatus()
        ));
    }

    @Override
    public void deleteById(Long id) {
        leaveRequestRepository.deleteById(id);
    }
}
