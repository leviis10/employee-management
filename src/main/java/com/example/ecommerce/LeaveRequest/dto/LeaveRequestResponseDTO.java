package com.example.ecommerce.LeaveRequest.dto;

import com.example.ecommerce.LeaveRequest.LeaveRequest;
import com.example.ecommerce.LeaveRequest.enums.LeaveRequestStatus;
import com.example.ecommerce.LeaveRequest.enums.LeaveType;
import com.example.ecommerce.employee.dto.EmployeeResponseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LeaveRequestResponseDTO {
    private Long id;
    private Long employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private LeaveType leaveType;
    private LeaveRequestStatus status;

    public static LeaveRequestResponseDTO toDTO(LeaveRequest leaveRequest) {
        return LeaveRequestResponseDTO.builder()
                .id(leaveRequest.getId())
                .employeeId(leaveRequest.getEmployee().getId())
                .startDate(leaveRequest.getStartDate())
                .endDate(leaveRequest.getEndDate())
                .leaveType(leaveRequest.getLeaveType())
                .status(leaveRequest.getStatus())
                .build();
    }
}
