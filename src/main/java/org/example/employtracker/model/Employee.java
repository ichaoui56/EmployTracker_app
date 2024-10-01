package org.example.employtracker.model;

import javax.persistence.*;


public class Employee {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private Double salary;

    public Employee() {}

    public Employee(String name, String email, String phone, String department, Double salary) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.salary = salary;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getDepartment() {return department;}

    public void setDepartment(String department) {this.department = department;}

    public Double getSalary() {return salary;}

    public void setSalary(Double salary) {this.salary = salary;}

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

