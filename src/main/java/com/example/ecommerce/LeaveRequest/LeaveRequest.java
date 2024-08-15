package com.example.ecommerce.LeaveRequest;

import com.example.ecommerce.LeaveRequest.enums.LeaveRequestStatus;
import com.example.ecommerce.LeaveRequest.enums.LeaveType;
import com.example.ecommerce.employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "leave_request")
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private LeaveType leaveType;

    @Column(nullable = false)
    private LeaveRequestStatus status;
}
