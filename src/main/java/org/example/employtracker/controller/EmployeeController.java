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
         default:
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
         default:
            break;
      }
   }

   private void showEmployeeForm(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      RequestDispatcher dispatcher = request.getRequestDispatcher("view/addForm.jsp");
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

      response.sendRedirect("employee?action=list");
   }

   private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
      int id = Integer.parseInt(request.getParameter("id"));
      employeeService.deleteEmployee(id);
      response.sendRedirect("employee?action=list");
   }


}
