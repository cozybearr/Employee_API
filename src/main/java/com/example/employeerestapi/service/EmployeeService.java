package com.example.employeerestapi.service;

import com.example.employeerestapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findEmployeeById(int id);

    List<Employee> findAllEmployee();
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployeeById(int id);
}
