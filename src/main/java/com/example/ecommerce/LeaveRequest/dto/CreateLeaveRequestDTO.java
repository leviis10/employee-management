package com.example.ecommerce.LeaveRequest.dto;

import com.example.ecommerce.LeaveRequest.enums.LeaveRequestStatus;
import com.example.ecommerce.LeaveRequest.enums.LeaveType;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
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
public class CreateLeaveRequestDTO {
    @NotNull(message = "Employee id cannot be blank")
    private Long employeeId;

    @NotNull(message = "Start date cannot be blank")
    private LocalDate startDate;

    @NotNull(message = "End date cannot be blank")
    private LocalDate endDate;

    @NotNull(message = "Leave type cannot be blank")
    private LeaveType leaveType;

    @NotNull(message = "Status cannot be blank")
    private LeaveRequestStatus status;
}
