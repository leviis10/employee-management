package com.example.ecommerce.LeaveRequest;

import com.example.ecommerce.LeaveRequest.enums.LeaveRequestStatus;
import com.example.ecommerce.LeaveRequest.enums.LeaveType;
import com.example.ecommerce.employee.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    @Transactional
    @Query(
            nativeQuery = true,
            value = "INSERT INTO leave_request (employee_id, start_date, end_date, leave_type, status) VALUES (:employeeId, :startDate, :endDate, :leaveType, :status) RETURNING *"
    )
    LeaveRequest save(
            @Param("employeeId") Long employeeId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("leaveType") LeaveType leaveType,
            @Param("status") LeaveRequestStatus status
    );

    @Query(nativeQuery = true, value = "SELECT * FROM leave_request")
    List<LeaveRequest> findAllNative();

    @Query(nativeQuery = true, value = "SELECT * FROM leave_request WHERE id = :id")
    LeaveRequest findByIdNative(@Param("id") Long id);

    @Transactional
    @Query(
            nativeQuery = true,
            value = "UPDATE leave_request SET start_date = :startDate, end_date = :endDate, leave_type = :leaveType, status = :status WHERE id = :id RETURNING *"
    )
    LeaveRequest updateById(
            @Param("id") Long id,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("leaveType") LeaveType leaveType,
            @Param("status") LeaveRequestStatus status
    );

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM leave_request WHERE id = :id")
    void deleteByIdNative(@Param("id") Long id);
}
