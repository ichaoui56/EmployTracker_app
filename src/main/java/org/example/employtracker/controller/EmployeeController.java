package org.example.employtracker.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.example.employtracker.dao.IEmployeeDao;
import org.example.employtracker.dao.impl.EmployeeDaoImpl;
import org.example.employtracker.model.Employee;
import org.example.employtracker.service.IEmployeeService;
import org.example.employtracker.service.impl.EmployeeServiceImpl;

import java.io.IOException;
import java.util.List;

public class EmployeeController extends HttpServlet {
   private IEmployeeDao employeeDao;
   private IEmployeeService employeeService;

   public EmployeeController(){
      this.employeeDao = new EmployeeDaoImpl();
      this.employeeService = new EmployeeServiceImpl(employeeDao);
   }

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String action = request.getParameter("action");

      switch (action) {
         case "showForm":
            showEmployeeForm(request, response);
            break;
         case "showEmployees":
            listEmployees(request, response);
            break;
         case "edit":
            showEditForm(request, response);
            break;
         default:
            response.sendRedirect("employee?action=showEmployees");
            break;
      }
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      String action = request.getParameter("action");

      switch (action) {
         case "insert":
            insertEmployee(request, response);
            break;
         case "delete":
            deleteEmployee(request, response);
            break;
         case "update":
            updateEmployee(request, response);
            break;
         default:
            response.sendRedirect("employee?action=showEmployees");
            break;
      }
   }

   private void showEmployeeForm(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      RequestDispatcher dispatcher = request.getRequestDispatcher("view/addForm.jsp");
      dispatcher.forward(request, response);
   }

   private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int id = Integer.parseInt(request.getParameter("id"));
      Employee existingEmployee = employeeService.getEmployeeById(id);
      request.setAttribute("employee", existingEmployee);
      RequestDispatcher dispatcher = request.getRequestDispatcher("editForm.jsp");
      dispatcher.forward(request, response);
   }

   private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
      String name = request.getParameter("name");
      String email = request.getParameter("email");
      String phoneNumber = request.getParameter("phone_number");
      String department = request.getParameter("department");
      Double salary = Double.valueOf(request.getParameter("salary"));

      Employee employee = new Employee(name, email, phoneNumber, department, salary);
      employeeService.addEmployee(employee);

      response.sendRedirect("employee?action=showEmployees");
   }

   private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
      int id = Integer.parseInt(request.getParameter("id"));
      employeeService.deleteEmployee(id);
      response.sendRedirect("employee?action=showEmployees");
   }

   private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      List<Employee> employees = employeeService.getAllEmployees();
      request.setAttribute("employees", employees);
      RequestDispatcher dispatcher = request.getRequestDispatcher("listEmployees.jsp");
      dispatcher.forward(request, response);
      System.out.println(employees);
   }

   private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
      int id = Integer.parseInt(request.getParameter("id"));
      String name = request.getParameter("name");
      String email = request.getParameter("email");
      String phoneNumber = request.getParameter("phone_number");
      String department = request.getParameter("department");
      Double salary = Double.valueOf(request.getParameter("salary"));

      Employee employee = new Employee(id, name, email, phoneNumber, department, salary);
      employeeService.updateEmployee(employee);

      response.sendRedirect("employee?action=showEmployees");
   }
}
