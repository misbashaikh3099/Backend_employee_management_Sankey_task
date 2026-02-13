package com.example.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_management.entity.Department;
import com.example.employee_management.repository.DepartmentRepository;
import com.example.employee_management.repository.EmployeeRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create department

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Get all departments

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Delete department (blocked if employees exist)

    public void deleteDepartment(Long id) {
        long count = employeeRepository.countByDepartmentId(id);

        if (count > 0) {
            throw new RuntimeException("Cannot delete department. Employees are assigned.");
        }

        departmentRepository.deleteById(id);
    }

    // Get department by id

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }
}
