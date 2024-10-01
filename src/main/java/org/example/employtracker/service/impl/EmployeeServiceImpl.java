package org.example.employtracker.service.impl;

import org.example.employtracker.dao.IEmployeeDao;
import org.example.employtracker.model.Employee;
import org.example.employtracker.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeDao employeeDao;

    public EmployeeServiceImpl(IEmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    public void addEmployee(Employee employee){
        employeeDao.insertEmployee(employee);
    }

}