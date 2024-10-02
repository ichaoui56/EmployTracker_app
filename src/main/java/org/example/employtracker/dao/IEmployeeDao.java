package org.example.employtracker.dao;

import org.example.employtracker.model.Employee;

import java.util.List;

public interface IEmployeeDao {
    void insertEmployee(Employee employee);
    void deleteEmployee(int id);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    Employee selectEmployeeById(int id);
}
