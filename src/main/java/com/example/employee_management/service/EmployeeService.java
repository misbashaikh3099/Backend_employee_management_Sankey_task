package com.example.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Create employee

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees with department & manager

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAllWithDepartmentAndManager();
    }

    // Get employee by ID

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // Update employee

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existing = getEmployeeById(id);

        existing.setFirstName(updatedEmployee.getFirstName());
        existing.setLastName(updatedEmployee.getLastName());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setDepartment(updatedEmployee.getDepartment());
        existing.setManager(updatedEmployee.getManager());

        return employeeRepository.save(existing);
    }

    // Delete employee (manager logic)

    public void deleteEmployee(Long id) {

        // Set manager_id = NULL for subordinates
        List<Employee> subordinates = employeeRepository.findByManagerId(id);
        for (Employee e : subordinates) {
            e.setManager(null);
        }
        employeeRepository.saveAll(subordinates);
        employeeRepository.deleteById(id);
    }
}