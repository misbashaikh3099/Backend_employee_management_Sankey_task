package com.example.employee_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.employee_management.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // JOIN to fetch department and manager

    @Query("""
        SELECT e FROM Employee e
        LEFT JOIN FETCH e.department
        LEFT JOIN FETCH e.manager
    """)
    List<Employee> findAllWithDepartmentAndManager();

    // Find employees under a manager

    List<Employee> findByManagerId(Long managerId);

    // Count employees in department
    
    long countByDepartmentId(Long departmentId);
}