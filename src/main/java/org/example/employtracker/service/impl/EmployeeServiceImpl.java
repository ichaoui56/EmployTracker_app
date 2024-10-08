package org.example.employtracker.service.impl;

import org.example.employtracker.dao.IEmployeeDao;
import org.example.employtracker.model.Employee;
import org.example.employtracker.service.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeDao employeeDao;

    public EmployeeServiceImpl(IEmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    @Override
    public void addEmployee(Employee employee){
        employeeDao.insertEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id){
        employeeDao.deleteEmployee(id);
    }

    @Override
    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }

    @Override
    public void updateEmployee(Employee employee){
        employeeDao.updateEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int id){
        return employeeDao.selectEmployeeById(id);
    }

    @Override
    public List<Employee> searchEmployees(String query) {
        return employeeDao.searchEmployees(query);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeDao.getEmployeesByDepartment(department);
    }

    @Override
    public List<String> getDistinctDepartments() {
        return employeeDao.getDistinctDepartments();
    }

}
