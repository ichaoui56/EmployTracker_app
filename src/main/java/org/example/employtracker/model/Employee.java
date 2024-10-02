package org.example.employtracker.model;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String department;
    private Double salary;

    public Employee(int id, String firstName,String lastName, String email, String phone, String department, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.salary = salary;
    }

    public Employee( String firstName,String lastName, String email, String phone, String department, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.salary = salary;
    }

    public Employee() {

    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String name) {this.firstName = name;}

    public String getLastName() {return lastName;}

    public void setLastName(String name) {this.lastName = name;}

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
                ", name='" + firstName + '\'' +
                ", name='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

