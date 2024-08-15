package com.example.ecommerce.employee;

import com.example.ecommerce.department.Department;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Transactional
    @Query(
            nativeQuery = true,
            value = "INSERT INTO employees (first_name, last_name, email, phone, hire_date, department_id) VALUES (:firstName, :lastName, :email, :phone, :hireDate, :departmentId) RETURNING *"
    )
    Employee save(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("email") String email,
            @Param("phone") String phone,
            @Param("hireDate") LocalDate hireDate,
            @Param("departmentId") Long departmentId
    );

    @Query(nativeQuery = true, value = "SELECT * FROM employees")
    List<Employee> findAllNative();

    @Query(nativeQuery = true, value = "SELECT * FROM employees WHERE id = :id")
    Employee findByIdNative(@Param("id") Long id);

    @Transactional
    @Query(
            nativeQuery = true,
            value = "UPDATE employees SET first_name = :firstName, last_name = :lastName, email = :email, phone = :phone, department_id = :departmentId WHERE id = :id RETURNING *"
    )
    Employee updateById(
            @Param("id") Long id,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("email") String email,
            @Param("phone") String phone,
            @Param("departmentId") Long departmentId
    );

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM employees WHERE id = :id")
    void deleteByIdNative(@Param("id") Long id);
}
