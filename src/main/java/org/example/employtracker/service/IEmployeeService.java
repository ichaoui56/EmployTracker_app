package org.example.employtracker.service;

import org.example.employtracker.model.Employee;

import java.util.List;

public interface IEmployeeService {
    void addEmployee(Employee employee);
    void deleteEmployee(int id);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    Employee getEmployeeById(int id);
}
