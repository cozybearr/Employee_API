package com.example.employeerestapi.Service;

import com.example.employeerestapi.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    Employee findEmployeeById(int id);

    List<Employee> findAllEmployee();
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployeeById(int id);
}
