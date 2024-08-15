package com.example.ecommerce.department;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO departments (department_name) VALUES (:departmentName) RETURNING *")
    Department save(@Param("departmentName") String departmentName);

    @Query(nativeQuery = true, value = "SELECT * FROM departments")
    List<Department> findAllNative();

    @Query(nativeQuery = true, value = "SELECT * FROM departments WHERE id = :id")
    Department findByIdNative(@Param("id") Long id);

    @Transactional
    @Query(nativeQuery = true, value = "UPDATE departments SET department_name = :departmentName WHERE id = :id RETURNING *")
    Department updateById(
            @Param("id") Long id,
            @Param("departmentName") String departmentName
    );

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM departments WHERE id = :id")
    void deleteByIdNative(@Param("id") Long id);
}
