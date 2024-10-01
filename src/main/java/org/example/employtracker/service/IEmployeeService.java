package org.example.employtracker.service;

import org.example.employtracker.model.Employee;

public interface IEmployeeService {
    void addEmployee(Employee employee);
    void deleteEmployee(int id);
}
